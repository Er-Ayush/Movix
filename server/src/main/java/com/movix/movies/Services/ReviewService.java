package com.movix.movies.Services;

import com.movix.movies.Common.Models.Reviews;

public interface ReviewService {
    Reviews createReview(String reviewBody, String imdbId);
}
