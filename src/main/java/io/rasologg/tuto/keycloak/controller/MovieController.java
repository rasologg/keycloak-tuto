package io.rasologg.tuto.keycloak.controller;

import io.rasologg.tuto.keycloak.domain.Movie;
import io.rasologg.tuto.keycloak.service.MovieService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Movie> getAll(){
        return movieService.getAll();
    }


    @GetMapping(value = "/movies/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie get(@PathVariable("id") Long id) {
        Movie movie = movieService.get(id);
        return movie;
    }

    @DeleteMapping("/movies/{id}")
    public void delete(@PathVariable Long id) {
        movieService.delete(id);
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> add(@RequestBody Movie movie) {
        Movie savedMovie = movieService.add(movie);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedMovie.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
