package com.cgi.service;

import com.cgi.dtos.FilterDto;
import com.cgi.repository.Movie;
import com.cgi.repository.MovieRepository;
import com.cgi.repository.MovieSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> getMoviesByFilter(List<FilterDto> filterDtoList) {
        return movieRepository.findAll(MovieSpecification.columnEqual(filterDtoList));
    }
}
