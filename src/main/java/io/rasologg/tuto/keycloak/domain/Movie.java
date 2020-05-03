package io.rasologg.tuto.keycloak.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    Long id;
    String code;
    String title;
    MovieType movieType = MovieType.PUBLIC;
    LocalDateTime releaseDate;
}
