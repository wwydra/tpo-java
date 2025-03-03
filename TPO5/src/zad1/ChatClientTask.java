package zad1;

import java.util.List;
import java.util.concurrent.FutureTask;

public class ChatClientTask extends FutureTask<String> {

    private final ChatClient client;

    private ChatClientTask(ChatClient client, List<String> messages, int wait) {
        super(() -> {
            client.login();
            if (wait != 0) {
                Thread.sleep(wait);
            }

            for (String message : messages) {
                client.send(message);
                if (wait != 0) {
                    Thread.sleep(wait);
                }
            }

            client.logout();
            if (wait != 0) {
                Thread.sleep(wait);
            }
            return null;
        });
        this.client = client;

    }

    public static ChatClientTask create(ChatClient c, List<String> msgs, int wait) {
        return new ChatClientTask(c, msgs, wait);
    }

    public ChatClient getClient() {
        return client;
    }
}
