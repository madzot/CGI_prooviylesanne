package com.cgi.mappers;

import com.cgi.dtos.MovieDto;
import com.cgi.repository.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieMapper {
    MovieDto movieToDto(Movie movie);
    Movie dtoToMovie(MovieDto dto);
}
