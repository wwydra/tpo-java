package zad1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ChatServer {

    private final String host;
    private final int port;
    private final StringBuilder serverLog;
    private ServerSocketChannel serverSocketChannel;
    private Selector selector;
    private Thread serverThread;

    public ChatServer(String host, int port) {
        this.host = host;
        this.port = port;
        this.serverLog = new StringBuilder();
    }

    public void startServer() throws IOException {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new java.net.InetSocketAddress(host, port));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        serverThread = new Thread(this::runServer);
        serverThread.start();
    }

    private void runServer() {
        System.out.println("Server started\n");
        try {
            while (!serverThread.isInterrupted()){
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();

                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if (key.isAcceptable()){
                        acceptClient(key);
                        continue;
                    }
                    if (key.isReadable()){
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        List<String> req = readReq(clientChannel, key);
                        readFromClient(req, clientChannel);
                    }
                }
            }

            if (selector.isOpen()){
                selector.close();
            }
            serverSocketChannel.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void acceptClient(SelectionKey key) throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        SocketChannel clientChannel = serverChannel.accept();
        clientChannel.configureBlocking(false);
        clientChannel.register(selector, SelectionKey.OP_READ);
    }

    private void readFromClient(List<String> requests, SocketChannel clientChannel) throws IOException {
        for (String req : requests) {
            String id;
            String[] parts = req.split("\n");
            id = parts[0];

            if (parts[1].contains("log in")) {
                String msg = id + " logged in";
                appendToServerLog(msg);
                broadcastMessage(msg);
            } else if (parts[1].contains("log out")) {
                String msg = id + " logged out";
                appendToServerLog(msg);
                broadcastMessage(msg);

                clientChannel.close();
                clientChannel.socket().close();
            } else {
                String msg = id + ": " + parts[1];
                appendToServerLog(msg);
                broadcastMessage(msg);
            }
        }
    }

    private List<String> readReq(SocketChannel socketChannel, SelectionKey key) throws IOException {
        StringBuilder stringBuilder = (StringBuilder) key.attachment();
        if (stringBuilder == null){
            stringBuilder = new StringBuilder();
        }
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Charset charset = StandardCharsets.UTF_8;
        List<String> messages = new ArrayList<>();

        while (true) {
            int n = socketChannel.read(buffer);
            if (n > 0) {
                buffer.flip();
                CharBuffer cbuf = charset.decode(buffer);
                while (cbuf.hasRemaining()){
                    stringBuilder.append(cbuf.get());
                }

                int lastIndex = stringBuilder.lastIndexOf("@");
                String res = null;
                if (lastIndex != -1){
                    res = stringBuilder.substring(0, lastIndex + 1);
                }
                if (res != null) {
                    String[] parts = res.split("@");
                    Collections.addAll(messages, parts);
                }
                stringBuilder = new StringBuilder(stringBuilder.substring(lastIndex + 1));
                key.attach(stringBuilder);
                return messages;
            }
        }
    }

    private void broadcastMessage(String message) throws IOException {
        message += "@";
        if (selector.isOpen()){
            Set<SelectionKey> keys = selector.keys();

            for (SelectionKey key : keys){
                if (key.isValid() && (key.channel() instanceof SocketChannel)) {
                    SocketChannel receiverChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
                    while (buffer.hasRemaining()){
                        receiverChannel.write(buffer);
                    }
                }
            }
        }
    }

    private void appendToServerLog(String action) {
        LocalDateTime curr = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        String formattedTime = curr.format(formatter);
        serverLog.append(formattedTime).append(' ').append(action).append('\n');
    }

    public void stopServer() {
        serverThread.interrupt();
        System.out.println("Server stopped");
    }

    public String getServerLog() {
        return serverLog.toString();
    }
}
