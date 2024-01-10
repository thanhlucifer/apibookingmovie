package org.example.apibookingmovie.repository;


import org.example.apibookingmovie.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}


