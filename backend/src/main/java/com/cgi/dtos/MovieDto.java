package com.cgi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MovieDto {
    private String title;
    private String genre;
    private String language;
    private Integer ageRestriction;
}
