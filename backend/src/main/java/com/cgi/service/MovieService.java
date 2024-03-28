package com.cgi.service;

import com.cgi.dtos.FilterDto;
import com.cgi.dtos.MovieDto;
import com.cgi.mappers.MovieMapper;
import com.cgi.repository.Movie;
import com.cgi.repository.MovieRepository;
import com.cgi.repository.MovieSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;

//    public List<MovieDto> getMoviesByFilter(List<FilterDto> filterDtoList) {
//        return movieRepository.findAll(MovieSpecification.columnEqual(filterDtoList));
//    }
    public List<MovieDto> getMovies() {
        List<Movie> allMovies = movieRepository.findAll();
        List<MovieDto> movies = new ArrayList<>();
        for (Movie movie: allMovies) {
            movies.add(movieMapper.movieToDto(movie));
            System.out.println(movie.getTitle());
        }
        return movies;
    }
}
