package Frames;

import Chat.ChatProducer;
import Chat.ChatConsumer;
import User.User;
import User.UserStorage;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.List;

public class ChatFrame extends JFrame {

    private final ChatConsumer chatConsumer;
    private final JTextPane chatArea;
    private final JTextField inputField;
    private final DefaultListModel<String> userListModel;
    private final UserStorage userStorage;
    private final StyledDocument chatDocument;

    public ChatFrame(String chatCode, String username, UserStorage userStorage) throws HeadlessException {
        this.userStorage = userStorage;
        chatConsumer = userStorage.getConsumers().get(userStorage.getUser(username));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Chat - " + username);
        this.setVisible(true);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);

        ChatProducer.login(chatCode, username);

        chatArea = new JTextPane();
        chatArea.setEditable(false);
        chatDocument = chatArea.getStyledDocument();
        JScrollPane chatScrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        inputField.setBackground(Color.LIGHT_GRAY);
        JButton sendButton = new JButton("Send");
        sendButton.setBackground(Color.LIGHT_GRAY);
        sendButton.setForeground(Color.BLACK);
        sendButton.setFont(sendButton.getFont().deriveFont(Font.BOLD));
        sendButton.addActionListener(e -> {
            String message = inputField.getText();
            if (!message.isEmpty()) {
                LocalDateTime curr = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                ChatProducer.send(chatCode, username + "," + message + "," + curr.format(formatter));
                inputField.setText("");
            }
        });

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        JButton logoutButton = new JButton("Log out");
        logoutButton.setBackground(Color.BLACK);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFont(logoutButton.getFont().deriveFont(Font.BOLD));
        logoutButton.addActionListener(e -> {
            ChatProducer.logout(chatCode, username);
            userStorage.setUserStatus(username, false);
            this.dispose();
        });

        userListModel = new DefaultListModel<>();
        JList<String> userList = new JList<>(userListModel);
        JScrollPane userScrollPane = new JScrollPane(userList);
        userScrollPane.setPreferredSize(new Dimension(120, 0));

        updateUsers();

        JPanel leftPanel = new JPanel(new BorderLayout());
        JLabel usersLabel = new JLabel("Users");
        usersLabel.setFont(usersLabel.getFont().deriveFont(Font.BOLD, 16));

        leftPanel.add(usersLabel, BorderLayout.NORTH);
        leftPanel.add(userScrollPane, BorderLayout.CENTER);

        JPanel logoutPanel = new JPanel(new BorderLayout());
        logoutPanel.add(logoutButton, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(chatScrollPane, BorderLayout.CENTER);
        rightPanel.add(inputPanel, BorderLayout.SOUTH);
        rightPanel.add(logoutPanel, BorderLayout.NORTH);

        this.setLayout(new BorderLayout());
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                userStorage.setUserStatus(username, false);
                super.windowClosing(e);
            }
        });

        Executors.newSingleThreadExecutor().submit(() -> {
            chatConsumer.loadChatHistory(chatArea, chatDocument);
            while (this.isVisible()) {
                chatConsumer.consumer.poll(Duration.of(1, ChronoUnit.SECONDS)).forEach(
                        m -> {
                            String message = m.value();
                            if (!message.contains("\u1F697")) {
                                appendToChat(message, username ,chatDocument);
                                chatArea.setCaretPosition(chatDocument.getLength());
                                chatArea.repaint();
                            }
                        }
                );

                updateUsers();
            }
        });
    }

    private void updateUsers() {
        SwingUtilities.invokeLater(() -> {
            userListModel.clear();
            List<User> users = userStorage.getUsers();
            for (User user : users) {
                String status = user.isLoggedIn() ? "(Online)" : "(Offline)";
                Color statusColor = user.isLoggedIn() ? Color.GREEN : Color.DARK_GRAY;

                String format = String.format("#%02x%02x%02x", statusColor.getRed(),
                        statusColor.getGreen(), statusColor.getBlue());
                String statusLabel = "<html><font>" + user.getUsername() + "</font><font color="
                        + format + ">  " + status + "</font></html>";

                userListModel.addElement(statusLabel);
            }
        });
    }

    public static void appendToChat(String message, String username, StyledDocument chatDocument) {
        SwingUtilities.invokeLater(() -> {
            try {
                String[] parts = message.split(",");
                String id = parts[0];
                String content = parts[1];
                String time = parts[2];

                SimpleAttributeSet usernameAttrs = new SimpleAttributeSet();
                StyleConstants.setForeground(usernameAttrs, Color.BLACK);

                SimpleAttributeSet timeAttrs = new SimpleAttributeSet();
                StyleConstants.setForeground(timeAttrs, Color.GRAY);
                StyleConstants.setFontSize(timeAttrs, 10);

                SimpleAttributeSet contentAttrs = new SimpleAttributeSet();
                StyleConstants.setFontSize(contentAttrs, 15);

                SimpleAttributeSet paragraphAttrs = new SimpleAttributeSet();
                if (id.equals(username)) {
                    StyleConstants.setForeground(contentAttrs, Color.WHITE);
                    StyleConstants.setBackground(contentAttrs, new Color(90, 130, 237));
                    StyleConstants.setAlignment(paragraphAttrs, StyleConstants.ALIGN_RIGHT);
                } else {
                    StyleConstants.setForeground(contentAttrs, Color.BLACK);
                    StyleConstants.setBackground(contentAttrs, Color.LIGHT_GRAY);
                    StyleConstants.setAlignment(paragraphAttrs, StyleConstants.ALIGN_LEFT);
                }

                int startLength = chatDocument.getLength();
                chatDocument.insertString(startLength, id + "\n", usernameAttrs);
                chatDocument.insertString(chatDocument.getLength(), content + "\n", contentAttrs);
                chatDocument.insertString(chatDocument.getLength(), time + "\n\n", timeAttrs);
                chatDocument.setParagraphAttributes(startLength, chatDocument.getLength() - startLength,
                        paragraphAttrs, false);

            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });

    }
}
