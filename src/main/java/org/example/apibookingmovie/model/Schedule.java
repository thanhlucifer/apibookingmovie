package org.example.apibookingmovie.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;


    @ManyToOne
    @JoinColumn(name = "movieId", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "roomId", nullable = false)
    private Room room;
    private LocalDate scheduleDate;
    private Time scheduleStart;
    private Time scheduleEnd;

    @Transient
    private String cinemaName; // Tạm thời để lưu trữ tên của cinema


    public String getCinemaName() {
        if (room != null && room.getCinema() != null) {
            return room.getCinema().getCinemaName();
        }
        return null;
    }


}
