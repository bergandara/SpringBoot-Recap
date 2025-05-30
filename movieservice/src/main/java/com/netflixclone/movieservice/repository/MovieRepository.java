package com.netflixclone.movieservice.repository;

import com.netflixclone.movieservice.entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findByTitleContainingIgnoreCase(String title);
    Optional<Movie> findByTitle(String title);

    List<Movie> findByGenre(String genre);
}
