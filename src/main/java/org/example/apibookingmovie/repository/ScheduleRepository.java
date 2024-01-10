package org.example.apibookingmovie.repository;

import org.example.apibookingmovie.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // Các phương thức tùy chỉnh nếu cần

}
