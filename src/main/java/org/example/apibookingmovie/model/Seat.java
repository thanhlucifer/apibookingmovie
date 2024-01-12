package org.example.apibookingmovie.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    private String seatType;


    @ManyToOne
    @JoinColumn(name = "roomId", nullable = false)
    private Room room;


    private String seatRow;
    private int seatNumber;

    // Trường đại diện cho trạng thái đặt (đã đặt hay chưa)
    @Column(columnDefinition = "BIT")
    private boolean booked;

    private double seatPrice;


}
