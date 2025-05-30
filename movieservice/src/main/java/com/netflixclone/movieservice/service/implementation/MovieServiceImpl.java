package com.netflixclone.movieservice.service.implementation;

import com.netflixclone.movieservice.dto.MovieRequestDTO;
import com.netflixclone.movieservice.dto.MovieResponseDTO;
import com.netflixclone.movieservice.entity.Movie;
import com.netflixclone.movieservice.repository.MovieRepository;
import com.netflixclone.movieservice.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    @Override
    public MovieResponseDTO createMovie(MovieRequestDTO request) {
        Movie newMovie = Movie.builder()
                .title(request.getTitle())
                .director(request.getDirector())
                .year(request.getYear())
                .genre(request.getGenre())
                .cast(request.getCast())
                .build();

        Movie saved = movieRepository.save(newMovie);
        return toResponseDTO(saved);
    }

    @Override
    public List<MovieResponseDTO> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MovieResponseDTO getMovieByTitle(String title) {
        Movie movie = movieRepository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("Movie not found: " + title));
        return toResponseDTO(movie);
    }

    @Override
    public void deleteMovie(String title) {
        Movie movie = movieRepository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("Movie not found: " + title));

        movieRepository.delete(movie);
    }

    @Override
    public List<MovieResponseDTO> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private MovieResponseDTO toResponseDTO(Movie movie){

        return MovieResponseDTO.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .director(movie.getDirector())
                .year(movie.getYear())
                .genre(movie.getGenre())
                .cast(movie.getCast())
                .build();
    }

}
