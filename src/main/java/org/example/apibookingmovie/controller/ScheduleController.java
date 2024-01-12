package org.example.apibookingmovie.controller;

import org.example.apibookingmovie.model.Schedule;
import org.example.apibookingmovie.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public List<Schedule> getAllSchedules() {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        for (Schedule schedule : schedules) {
            // Sử dụng getCinemaName để lấy tên của Cinema từ mỗi đối tượng Schedule.
            String cinemaName = schedule.getCinemaName();
            // Do something with cinemaName if needed.
        }
        return schedules;
    }
    @GetMapping("/{id}")
    public Schedule getScheduleById(@PathVariable Long id) {
        return scheduleService.getScheduleById(id);
    }

    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.createSchedule(schedule);
    }

    @PutMapping("/{id}")
    public Schedule updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {
        return scheduleService.updateSchedule(id, schedule);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
    }

    @GetMapping("/movies/{movieId}")
    public List<Schedule> getSchedulesByMovieId(@PathVariable Long movieId) {
        return scheduleService.getSchedulesByMovieId(movieId);
    }
}

