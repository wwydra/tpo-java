package zad1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

public class ChatClient {

    private final String host;
    private final int port;
    private final String id;
    private final StringBuilder chatView;
    private SocketChannel socketChannel;
    private ResponseReceiverThread receiverThread;
    private boolean isLogged;
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public ChatClient(String host, int port, String id) {
        this.host = host;
        this.port = port;
        this.id = id;
        this.isLogged = false;
        this.chatView = new StringBuilder();
        this.chatView.append("=== ").append(id).append(" chat view\n");
    }

    public void login(){
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(host, port));
            socketChannel.configureBlocking(false);
            send("log in");
        }catch (IOException e){
            e.printStackTrace();
        }
        receiverThread = new ResponseReceiverThread();
        receiverThread.start();
    }

    public void logout() throws IOException, InterruptedException {
        send("log out");
        countDownLatch.await();
    }

    public void send(String req) throws IOException {
        req = id + '\n' + req + '@';
        ByteBuffer buffer = ByteBuffer.wrap(req.getBytes());
        while (buffer.hasRemaining()){
            socketChannel.write(buffer);
        }
        buffer.clear();
        readServerResponse();
    }

    private void readServerResponse() throws IOException {
        StringBuilder response = new StringBuilder();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Charset charset = StandardCharsets.UTF_8;

        if (socketChannel.isOpen()) {
            int n = socketChannel.read(buffer);
            if (n == -1){
                receiverThread.interrupt();
                return;
            }
            if (n > 0) {
                while (true) {
                    if (n > 0) {
                        buffer.flip();
                        CharBuffer cbuf = charset.decode(buffer);
                        char c;
                        while ((c = cbuf.get()) != '@') {
                            response.append(c);
                        }
                        n = socketChannel.read(buffer);
                    } else {
                        break;
                    }
                }
            }
        }
        if (!response.toString().isEmpty()) {
            if (isLogged) {
                this.chatView.append(response).append('\n');
                if (response.toString().equals(id + " logged out")) {
                    receiverThread.interrupt();
                }
            }else if (response.toString().equals(id + " logged in")){
                this.chatView.append(response).append('\n');
                isLogged = true;
            }
        }
    }

    public String getChatView(){
        this.chatView.append('\n');
        return chatView.toString();
    }

    private class ResponseReceiverThread extends Thread {
        @Override
        public void run() {
            try {
                while (!isInterrupted() && socketChannel.isOpen()) {
                    readServerResponse();
                }
                countDownLatch.countDown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
