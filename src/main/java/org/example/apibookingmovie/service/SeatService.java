package org.example.apibookingmovie.service;

import org.example.apibookingmovie.model.Seat;
import org.example.apibookingmovie.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seat getSeatById(Long id) {
        return seatRepository.findById(id).orElse(null);
    }

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public Seat updateSeat(Long id, Seat seat) {
        if (seatRepository.existsById(id)) {
            seat.setSeatId(id);
            return seatRepository.save(seat);
        }
        return null;
    }

    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);
    }
}
