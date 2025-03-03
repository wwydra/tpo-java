package Chat;

import User.UserStorage;
import Frames.ChatFrame;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import javax.swing.*;
import javax.swing.text.StyledDocument;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Map;

public class ChatConsumer {
    public KafkaConsumer<String, String> consumer;
    private static final String LOGIN_PREFIX = "\u1F697 LOGIN:";
    private static final String LOGOUT_PREFIX = "\u1F697 LOGOUT:";
    private final String username;

    public ChatConsumer(String topic, String username, UserStorage userStorage) {
        this.username = username;

        consumer = new KafkaConsumer<>(
                Map.of(
                        ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                        ConsumerConfig.GROUP_ID_CONFIG, username,
                        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName(),
                        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName()
                )
        );

        consumer.subscribe(Collections.singletonList(topic));
        consumer.poll(Duration.of(1, ChronoUnit.SECONDS)).forEach(record -> {
            String message = record.value();
            if (message.startsWith(LOGIN_PREFIX)) {
                String id = message.substring(LOGIN_PREFIX.length());
                userStorage.setUserStatus(id, true);
            } else if (message.startsWith(LOGOUT_PREFIX)) {
                String id = message.substring(LOGOUT_PREFIX.length());
                userStorage.setUserStatus(id, false);
            } else {
                System.out.println(username + ": " + message);
            }
        });
    }

    public void loadChatHistory(JTextPane chatArea, StyledDocument chatDocument) {
        consumer.seekToBeginning(consumer.assignment());
        ConsumerRecords<String, String> records = consumer.poll(Duration.of(1, ChronoUnit.SECONDS));
        for (ConsumerRecord<String, String> record : records) {
            String message = record.value();
            if (!message.contains("\u1F697")) {
                ChatFrame.appendToChat(message, username ,chatDocument);
                chatArea.setCaretPosition(chatDocument.getLength());
                chatArea.repaint();
            }
        }
    }

    public ConsumerRecords<String, String> pollUsers(Duration timeout) {
        return consumer.poll(timeout);
    }

    public void close() {
        consumer.close();
    }
}
