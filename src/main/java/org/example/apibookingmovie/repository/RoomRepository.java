package org.example.apibookingmovie.repository;

import org.example.apibookingmovie.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    // Các phương thức tùy chỉnh nếu cần
}

