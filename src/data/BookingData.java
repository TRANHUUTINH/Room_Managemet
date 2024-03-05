package data;

import entity.Booking;
import entity.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookingData {
    private static final String FILE_PATH = "F:\\codegym 2\\Room_Managemet\\src\\file\\book.csv";

    public static List<Booking> getAllBooking() {
        List<Booking> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String userCus = data[1];
                String userHost = data[2];
                int roomId =  Integer.parseInt(data[3]);

                Booking booking = new Booking(id, userCus, userHost, roomId);
                books.add(booking);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static void writeBookingToFile(List<Booking> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Booking booking : books) {
                String line = booking.getBookingId() + "," + booking.getUserNameCustomer() + "," +booking.getUserNameHost() + ","
                        + booking.getRoomId();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
