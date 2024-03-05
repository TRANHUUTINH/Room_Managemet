package service;

import data.BookingData;
import data.MessageData;
import data.RoomData;
import entity.Booking;
import entity.Message;
import entity.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomManagementService {
    static Scanner scanner = new Scanner(System.in);
    private static List<Room> roomList = new ArrayList<>();
    private static List<Booking> bookingList = new ArrayList<>();
    private static final String DUOI = ".CSV";


    static {
        roomList.addAll(RoomData.getAllRooms());
        RoomData.saveAllRooms(roomList);
        bookingList.addAll(BookingData.getAllBooking());
        BookingData.writeBookingToFile(bookingList);
    }

    public static List<Booking> viewBooking() {
        List<Booking> list = new ArrayList<>();
        for(Booking ele : bookingList){
            System.out.println(ele);
            list.add(ele);
        }

      return list;
    }
    public static void message(){

        if(RoomManagementService.viewBooking().size() == 0){
            System.out.println("ko co booking xem phong nao");
        }else {

            System.out.println("Chon booking id de nhan tin voi khach hang");
            int bookingId = scanner.nextInt();
            String userHost = null;
            String userCus = null;
            for(Booking ele : bookingList){
                if(ele.getBookingId() == bookingId){
                    userCus = ele.getUserNameCustomer();
                    userHost = ele.getUserNameHost();
                    break;
                }
            }

            scanner.nextLine();
            String path = userCus + userHost + ".csv";
            List<Message> messageList = MessageData.getMessage(path);
            System.out.println("Nhan tin de bat dau tro chuyen");
            String chat = scanner.nextLine();
            Message newMessage = new Message(chat);
            messageList.add(newMessage);
            MessageData.writeMessageToCustomer(messageList,path);


        }

    }


    public boolean addRoom(Room rooms) {
        roomList.add(rooms);
        RoomData.saveAllRooms(roomList);
        return false;
    }

    public boolean deleteRoom(int roomId) {
        for (Room room : roomList) {
            if (room.getId() == roomId) {
                roomList.remove(room);
                return true;
            }
        }
        return false;
    }

    public void updateRoom(int roomId, String roomInfo) {
        for (Room room : roomList) {
            if (room.getId() == roomId) {
                room.setInfo(roomInfo);
                return;
            }
        }
        System.out.println("Không tìm thấy phòng với ID: " + roomId);
    }
    public static void searchRoomsByDistrict(String district) {
        for (Room room : roomList) {
            if (room.getDistrict().equalsIgnoreCase(district.trim())) {
                System.out.println(room);            }
        }
    }
    public static void booking(int bookingId,String userNameCustomer, String userNameHost, int roomId){
        Booking booking = new Booking(bookingId,userNameCustomer,userNameHost,roomId);

        bookingList.add(booking);
        System.out.println("Booking thanh cong ");
        BookingData.writeBookingToFile(bookingList);
    }
}
