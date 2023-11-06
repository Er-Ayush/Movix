package com.movix.movies.Services;

import com.movix.movies.Common.Models.Movies;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movies> allmovies();

    Optional<Movies> getbyid(String imdbId);


    String trending(String s);
}
