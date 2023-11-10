package com.movix.movies.Services;

import com.movix.movies.Common.Models.Users;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface Userservice {

    boolean userExists(String username);

    void saveUser(Users newUser);


    Optional<List<Users>> getusers();

    boolean userExistsInDatabase(String username, String pass);

    String getUser(String username);

    String addfav(String imdbId, String username);

    List<String> getFav(String username);
}
