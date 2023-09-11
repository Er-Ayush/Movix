package com.movix.movies.Services.Imp;

import com.movix.movies.Common.Models.Movies;
import com.movix.movies.Common.Repositories.MoviesRepository;
import com.movix.movies.Services.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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


}
