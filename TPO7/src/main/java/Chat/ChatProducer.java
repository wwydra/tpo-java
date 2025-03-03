package Chat;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Map;

public class ChatProducer {

    private static final String LOGIN_PREFIX = "\u1F697 LOGIN:";
    private static final String LOGOUT_PREFIX = "\u1F697 LOGOUT:";
    private static final String REGISTER_PREFIX = "\u1F697 REGISTER:";

    private static final KafkaProducer<String, String> producer = new KafkaProducer<>(
            Map.of(
                    ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                    ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName(),
                    ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName()
            )
    );

    public static void send(String topic, String message) {
        producer.send(new ProducerRecord<>(topic, message));
    }

    public static void register(String topic, String username, String password, String chatCode) {
        send(topic, REGISTER_PREFIX + username + "," + password + "," + chatCode);
    }

    public static void login(String topic, String username) {
        send(topic, LOGIN_PREFIX + username);
    }

    public static void logout(String topic, String username) {
        send(topic, LOGOUT_PREFIX + username);
    }

    public void close(){
        producer.close();
    }
}
