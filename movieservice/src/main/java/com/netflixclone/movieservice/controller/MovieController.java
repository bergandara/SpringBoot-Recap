package com.netflixclone.movieservice.controller;

import com.netflixclone.movieservice.dto.MovieRequestDTO;
import com.netflixclone.movieservice.dto.MovieResponseDTO;
import com.netflixclone.movieservice.service.MovieService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;


    @PostMapping
    public ResponseEntity<MovieResponseDTO> createMovie(@Valid @RequestBody MovieRequestDTO request){
        return ResponseEntity.ok(movieService.createMovie(request));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponseDTO>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{title}")
    public ResponseEntity<MovieResponseDTO> getMovieByTitle(@PathVariable String title){
        return ResponseEntity.ok(movieService.getMovieByTitle(title));
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String title){
        movieService.deleteMovie(title);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<MovieResponseDTO>> getMoviesByGenre(@PathVariable String genre){
        return ResponseEntity.ok(movieService.getMoviesByGenre(genre));
    }
}
