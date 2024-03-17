package com.cgi.controller;

import com.cgi.dtos.FilterDto;
import com.cgi.repository.Movie;
import com.cgi.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping(path = "/api/movies")
    public ResponseEntity<List<Movie>> getMovies(@Valid @RequestBody List<FilterDto> filterDtoList) {
        return ResponseEntity.ok().body(movieService.getMoviesByFilter(filterDtoList));
    }
}
