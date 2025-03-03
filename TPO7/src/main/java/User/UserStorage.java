package User;

import Chat.ChatConsumer;
import Chat.ChatProducer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class UserStorage {

    private final Map<String, User> users = new HashMap<>();
    private static final String USER_TOPIC = "user_topic";
    private  final Map<User, ChatConsumer> consumers = new HashMap<>();

    public UserStorage() {
        ChatConsumer consumer = new ChatConsumer(USER_TOPIC, "user-loader", this);
        ConsumerRecords<String, String> records = consumer.pollUsers(Duration.of(1, ChronoUnit.SECONDS));
        for (ConsumerRecord<String, String> record : records) {
            String message = record.value();
            if (message.startsWith("\u1F697 REGISTER:")) {
                String[] parts = message.substring("\u1F697 REGISTER:".length()).split(",");
                String username = parts[0];
                String password = parts[1];
                String chatCode = parts[2];
                users.put(username, new User(username, password, chatCode));
            }
        }
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
        ChatConsumer consumer = new ChatConsumer(user.getChatCode(), user.getUsername(), this);
        consumers.put(user, consumer);
        setUserStatus(user.getUsername(), true);
        ChatProducer.register(USER_TOPIC, user.getUsername(), user.getPassword(), user.getChatCode());
    }

    public void setUserStatus(String username, boolean status) {
        User user = users.get(username);
        if (user != null) {
            user.setLoggedIn(status);
        }
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public Map<User, ChatConsumer> getConsumers() {
        return consumers;
    }
}