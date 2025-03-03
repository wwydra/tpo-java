package User;

public class User {
    private final String username;
    private final String password;
    private final String chatCode;
    private boolean loggedIn;

    public User(String username, String password, String chatCode) {
        this.username = username;
        this.password = password;
        this.chatCode = chatCode;
        this.loggedIn = false;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getChatCode() {
        return chatCode;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
