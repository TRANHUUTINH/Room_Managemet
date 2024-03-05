package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.Room;

public class RoomData {
    private static final String FILE_PATH = "F:\\codegym 2\\Room_Managemet\\src\\file\\rooms.csv";

    public static List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String district = data[1];
                String street = data[2];
                String type = data[3];
                double price = Double.parseDouble(data[4]);
                String bookedBy = data[5];
                Room room = new Room(id, district, street, type, price, bookedBy);
                rooms.add(room);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public static void saveAllRooms(List<Room> rooms) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Room room : rooms) {
                String line = room.getId() + "," + room.getDistrict() + "," + room.getStreet() + ","
                        + room.getType() + "," + room.getPrice() + "," + room.getBookedBy();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
