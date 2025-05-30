package com.netflixclone.movieservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponseDTO {
    private String id;
    private String title;
    private String director;
    private Integer year;
    private String genre;
    private List<String> cast;
}
