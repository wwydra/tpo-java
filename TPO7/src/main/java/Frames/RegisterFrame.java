package Frames;

import User.UserStorage;
import User.User;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {

    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JPasswordField confirmPasswordField;
    private final JTextField chatCodeField;
    private final UserStorage userStorage;

    public RegisterFrame(UserStorage userStorage) {
        this.userStorage = userStorage;

        this.setTitle("Register");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        usernameField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel confirmPasswordLabel = new JLabel("Repeat password:");
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel chatCodeLabel = new JLabel("Chat code:");
        chatCodeField = new JTextField();
        chatCodeField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JButton registerButton = createButton();

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(confirmPasswordLabel);
        panel.add(confirmPasswordField);
        panel.add(chatCodeLabel);
        panel.add(chatCodeField);
        panel.add(new JLabel());
        panel.add(registerButton);

        this.add(panel);
    }

    private JButton createButton() {
        JButton registerButton = new JButton("Register");
        registerButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(registerButton.getFont().deriveFont(Font.BOLD));
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());
            String chatCode = chatCodeField.getText();

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(RegisterFrame.this, "Passwords do not match",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (username.isEmpty() || password.isEmpty() || chatCode.isEmpty()) {
                JOptionPane.showMessageDialog(RegisterFrame.this, "All fields must be completed",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            User newUser = new User(username, password, chatCode);

            if (userStorage.getUser(username) != null) {
                JOptionPane.showMessageDialog(RegisterFrame.this, "This username already exists",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            userStorage.addUser(newUser);
            SwingUtilities.invokeLater(() -> new ChatFrame(newUser.getChatCode(), username, userStorage));
            this.dispose();
        });
        return registerButton;
    }
}
