import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.IOException;

public class NotificationReceiver extends Thread {
    private final DataInputStream dataInputStream;

    public NotificationReceiver(DataInputStream dataInputStream) {
        this.dataInputStream = dataInputStream;
    }

    @Override
    public synchronized void run() {
        while (true) {
            String data = null;
            try {
                data = dataInputStream.readUTF();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (!data.startsWith("{"))
                System.out.println(data);
            else {
                Packet packet = new Gson().fromJson(data, Packet.class);
                if (packet.command.equals("new task added"))
                    System.out.println(packet.command + " name: " + packet.topic);
            }
        }
    }
}
