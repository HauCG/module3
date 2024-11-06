package org.example.module_three.service;

import org.example.module_three.model.Room;
import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();
    Room getRoomById(int roomId);
    boolean createRoom(Room room);
    boolean deleteRoom(int roomId);
}
