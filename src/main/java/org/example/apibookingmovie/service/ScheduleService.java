package org.example.apibookingmovie.service;

import org.example.apibookingmovie.model.Schedule;
import org.example.apibookingmovie.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        // Lặp qua danh sách và có thể sử dụng getCinemaName để lấy tên của Cinema từ mỗi đối tượng Schedule.
        for (Schedule schedule : schedules) {
            String cinemaName = schedule.getCinemaName();
            // Do something with cinemaName if needed.
        }
        return schedules;
    }

    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Schedule updateSchedule(Long id, Schedule schedule) {
        if (scheduleRepository.existsById(id)) {
            schedule.setScheduleId(id);
            return scheduleRepository.save(schedule);
        }
        return null;
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }

    public List<Schedule> getSchedulesByMovieId(Long movieId) {
        return scheduleRepository.findByMovieMovieId(movieId);
    }
}
