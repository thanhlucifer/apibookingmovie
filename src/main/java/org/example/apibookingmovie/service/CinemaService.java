package org.example.apibookingmovie.service;

import org.example.apibookingmovie.model.Cinema;
import org.example.apibookingmovie.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    public Cinema getCinemaById(Long id) {
        return cinemaRepository.findById(id).orElse(null);
    }

    public Cinema createCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    public Cinema updateCinema(Long id, Cinema cinema) {
        if (cinemaRepository.existsById(id)) {
            cinema.setCinemaId(id);
            return cinemaRepository.save(cinema);
        }
        return null;
    }

    public void deleteCinema(Long id) {
        cinemaRepository.deleteById(id);
    }
}
