package com.movix.movies.Common.Repositories;

import com.movix.movies.Common.Models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UsersRepository extends MongoRepository<Users, String> {
    Optional<Users> findByUsername(String username);

//    @Query("{'username': ?0, 'password': ?1}")
//    Optional<Users> findByUsernameAndPassword(String username, String pass);
}
