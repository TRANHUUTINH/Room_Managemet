package service;

import data.RoomData;
import entity.Room;

import java.util.List;

public class RoomBookingService {
    private RoomData roomData;

    public RoomBookingService() {
        this.roomData = new RoomData();
    }

    public boolean bookRoom(int roomId, String username) {
        List<Room> allRooms = roomData.getAllRooms();
        for (Room room : allRooms) {
            if (room.getId() == roomId && room.getBookedBy() == null) {
                room.setBookedBy(username);
                roomData.saveAllRooms(allRooms);
                return true;
            }
        }
        return false;
    }
}
