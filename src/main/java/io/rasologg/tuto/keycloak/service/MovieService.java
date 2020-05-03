package io.rasologg.tuto.keycloak.service;

import io.rasologg.tuto.keycloak.domain.Movie;
import io.rasologg.tuto.keycloak.domain.MovieType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class MovieService {
    public static final Map<Long, Movie> movies = new LinkedHashMap<>();

    static {
        Movie movie1 = new Movie(1L, "MOVIE001", "Movie Title 1", MovieType.PUBLIC, LocalDateTime.now());
        Movie movie2 = new Movie(2L, "MOVIE002", "Movie Title 2", MovieType.PUBLIC, LocalDateTime.now());
        Movie movie3 = new Movie(3L, "MOVIE003", "Movie Title 3", MovieType.TEEN, LocalDateTime.now());
        Movie movie4 = new Movie(4L, "MOVIE004", "Movie Title 4", MovieType.ADULT, LocalDateTime.now());
        movies.put(movie1.getId(), movie1);
        movies.put(movie2.getId(), movie2);
        movies.put(movie3.getId(), movie3);
        movies.put(movie4.getId(), movie4);
    }

    public Movie get(Long id) {
        return movies.get(id);
    }

    public Movie add(Movie course) {
        movies.put(course.getId(), course);
        return course;
    }

    public void delete(long id) {
        movies.remove(id);
    }

    public Collection<Movie> getAll() {
        return movies.values();
    }
}
