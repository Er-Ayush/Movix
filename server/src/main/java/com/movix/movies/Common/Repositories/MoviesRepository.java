package com.movix.movies.Common.Repositories;

import com.movix.movies.Common.Models.Movies;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoviesRepository extends MongoRepository<Movies,ObjectId> {
    Optional<Movies> findMovieByImdbId(String imdbId);
}
