package org.example.apibookingmovie.repository;

import org.example.apibookingmovie.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

}

