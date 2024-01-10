package org.example.apibookingmovie.controller;

import org.example.apibookingmovie.model.Cinema;
import org.example.apibookingmovie.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping
    public List<Cinema> getAllCinemas() {
        return cinemaService.getAllCinemas();
    }

    @GetMapping("/{id}")
    public Cinema getCinemaById(@PathVariable Long id) {
        return cinemaService.getCinemaById(id);
    }

    @PostMapping
    public Cinema createCinema(@RequestBody Cinema cinema) {
        return cinemaService.createCinema(cinema);
    }

    @PutMapping("/{id}")
    public Cinema updateCinema(@PathVariable Long id, @RequestBody Cinema cinema) {
        return cinemaService.updateCinema(id, cinema);
    }

    @DeleteMapping("/{id}")
    public void deleteCinema(@PathVariable Long id) {
        cinemaService.deleteCinema(id);
    }
}
