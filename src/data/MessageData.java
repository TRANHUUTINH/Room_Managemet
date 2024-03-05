package data;

import entity.Booking;
import entity.Message;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MessageData {
    public static List<Message> getMessage(String path) {
        List<Message> messages = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                String message = data[0];
               Message message1 = new Message(message);
               messages.add(message1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return messages;
    }

    public static void writeMessageToCustomer(List<Message> messages, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Message ele : messages) {
                String line =ele.getMessage();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
