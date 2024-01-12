package org.example.apibookingmovie.repository;

import org.example.apibookingmovie.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByMovieMovieId(Long movieId);

}
