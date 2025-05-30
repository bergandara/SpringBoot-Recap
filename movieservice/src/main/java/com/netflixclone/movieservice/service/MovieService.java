package com.netflixclone.movieservice.service;


import com.netflixclone.movieservice.dto.MovieRequestDTO;
import com.netflixclone.movieservice.dto.MovieResponseDTO;
import com.netflixclone.movieservice.entity.Movie;
import com.netflixclone.movieservice.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

public interface MovieService{

    MovieResponseDTO createMovie(MovieRequestDTO movieDTO);
    List<MovieResponseDTO> getAllMovies();
    MovieResponseDTO getMovieByTitle(String title);
    void deleteMovie(String id);

    List<MovieResponseDTO> getMoviesByGenre(String genre);

}
