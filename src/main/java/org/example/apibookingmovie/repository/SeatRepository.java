package org.example.apibookingmovie.repository;

import org.example.apibookingmovie.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    // Các phương thức tùy chỉnh nếu cần
}
