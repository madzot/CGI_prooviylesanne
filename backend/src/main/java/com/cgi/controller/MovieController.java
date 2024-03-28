package com.cgi.controller;

import com.cgi.dtos.FilterDto;
import com.cgi.dtos.MovieDto;
import com.cgi.repository.Movie;
import com.cgi.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping(path = "/api/movies")
    public ResponseEntity<List<MovieDto>> getMovies(@Valid @RequestBody List<FilterDto> filterDtoList) {
        return ResponseEntity.ok().body(movieService.getMovies());
    }
}
