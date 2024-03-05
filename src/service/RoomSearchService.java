package service;

import data.RoomData;
import entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomSearchService {
    private RoomData roomData;

    public RoomSearchService() {
        this.roomData = new RoomData();
    }

    public List<Room> searchRoomsByDistrict(String district) {
        List<Room> allRooms = roomData.getAllRooms();
        List<Room> matchedRooms = new ArrayList<>();
        for (Room room : allRooms) {
            if (room.getDistrict().equalsIgnoreCase(district)) {
                matchedRooms.add(room);
            }
        }
        return matchedRooms;
    }
}
