package com.netflixclone.movieservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "movies") // maps to movie collections in MongoDB database
public class Movie {

    @Id
    private String id;
    private String title;
    private List<String> cast;
    private Integer year;
    private String director;
    private String genre;
}
