package com.movix.movies.Services.Imp;

import com.movix.movies.Common.Models.Movies;
import com.movix.movies.Common.Repositories.MoviesRepository;
import com.movix.movies.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImp implements MovieService {

   @Autowired
   private MoviesRepository moviesRepository;
   @Override
   public List<Movies> allmovies() {
      return moviesRepository.findAll();
   }

   @Override
   public Optional<Movies> getbyid(String imdbId) {
      return moviesRepository.findMovieByImdbId(imdbId);
   }

   @Override
   public String trending(String s) {
      RestTemplate restTemplate = new RestTemplate();
      String apiKey = "72047576d8a289a1599fcbe252e7a527";
      String apiUrl = "https://api.themoviedb.org/3/movie/popular?language=en-US&page="+s+"&api_key=" + apiKey;

      String str = restTemplate.getForObject(apiUrl,String.class).toString();
      return str;
   }



}
