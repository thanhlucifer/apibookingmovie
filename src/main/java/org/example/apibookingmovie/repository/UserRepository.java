package org.example.apibookingmovie.repository;

import org.example.apibookingmovie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Các phương thức tùy chỉnh nếu cần
}
