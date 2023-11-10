package com.movix.movies.Controller;

import com.movix.movies.Common.Models.Movies;
import com.movix.movies.Services.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movies>> getAllmovies(){
        return new ResponseEntity<List<Movies>>(movieService.allmovies(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movies>> getMovieById(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movies>>(movieService.getbyid(imdbId),HttpStatus.OK);
    }

    @GetMapping("/trending/{pageNo}")
    public String trending(@PathVariable String pageNo){
        String s=movieService.trending(pageNo);
        return s;
    }

}
