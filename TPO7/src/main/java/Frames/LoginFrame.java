package Frames;

import User.UserStorage;
import User.User;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final UserStorage userStorage;

    public LoginFrame() {
        userStorage = new UserStorage();

        this.setTitle("Login");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        usernameField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(loginButton.getFont().deriveFont(Font.BOLD));

        JButton registerButton = new JButton("Register");
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(registerButton.getFont().deriveFont(Font.BOLD));

        panel.add(loginButton);
        panel.add(registerButton);

        this.add(panel);

        registerButton.addActionListener(e -> SwingUtilities.invokeLater(() -> new RegisterFrame(userStorage)));

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            User user = userStorage.getUser(username);
            if (user != null && user.getPassword().equals(password)) {
                SwingUtilities.invokeLater(() -> new ChatFrame(user.getChatCode(), username, userStorage));
                userStorage.setUserStatus(user.getUsername(), true);
            } else {
                JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            usernameField.setText("");
            passwordField.setText("");
        });
    }
}
