package org.example.apibookingmovie.service;

import org.example.apibookingmovie.model.Room;
import org.example.apibookingmovie.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Long id, Room room) {
        if (roomRepository.existsById(id)) {
            room.setRoomId(id);
            return roomRepository.save(room);
        }
        return null;
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
