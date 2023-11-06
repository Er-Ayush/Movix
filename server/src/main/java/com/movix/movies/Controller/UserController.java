package com.movix.movies.Controller;

import com.movix.movies.Common.Models.Users;
import com.movix.movies.Services.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    private Userservice userservice;
    @PostMapping("/signup")
    public ResponseEntity<String> createUser(@RequestBody Map<String, String> payload) {
        String name =payload.get("name");
        String username = payload.get("username");
        String pass = payload.get("pass");

        if(username==null || pass==null || name ==null){
            return ResponseEntity.badRequest().body("field is empty");
        }
        // Validate input data (e.g., check for null values, password complexity)

        // Check if the username already exists
        if (userservice.userExists(username)) {
            return ResponseEntity.ok().body("Username already exists");
        }

        // Create a new user
        Users newUser = new Users();
        newUser.setUsername(username);
        newUser.setPass(pass); // You should hash and salt the password for security
        newUser.setName(name);

        // Save the user
        userservice.saveUser(newUser);

        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping
    public ResponseEntity<Optional<List<Users>>> getalluser(){
        Optional<List<Users>> users = userservice.getusers();

        if (users.isPresent()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping ("/login")
    public ResponseEntity<String> loginAuth(@RequestBody Map<String, String> payload){
        String username = payload.get("username");
        String pass = payload.get("pass");

        Users newUsers = new Users();
        newUsers.setUsername(username);
        newUsers.setPass(pass);
//        System.out.println(username);
//        System.out.println(pass);
        if(username=="" || pass=="" ){
            return ResponseEntity.badRequest().body("field is empty");
        }
        System.out.println(userservice.userExistsInDatabase(username,pass));
        if (userservice.userExistsInDatabase(username,pass)) {
            return ResponseEntity.ok().body(userservice.getUser(username));
        }
        else{
            return ResponseEntity.badRequest().body("Bad Creds");
        }

    }

}

