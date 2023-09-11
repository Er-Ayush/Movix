package com.movix.movies.Services.Imp;

import com.movix.movies.Common.Models.Movies;
import com.movix.movies.Common.Models.Reviews;
import com.movix.movies.Common.Repositories.ReviewRepository;
import com.movix.movies.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImp implements ReviewService {
    @Autowired
    public ReviewRepository reviewRepository;

    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public Reviews  createReview(String reviewBody, String imdbId) {
        Reviews reviews = reviewRepository.insert(new Reviews(reviewBody));
        mongoTemplate.update(Movies.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(reviews))
                .first();
        return reviews;
    }
}
