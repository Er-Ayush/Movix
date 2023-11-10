package com.movix.movies.Services.Imp;

import com.movix.movies.Common.Models.Users;
import com.movix.movies.Common.Repositories.UsersRepository;
import com.movix.movies.Services.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImp implements Userservice {
    @Autowired
    private UsersRepository usersRepository;


    @Override
    public boolean userExists(String username) {
        Optional<Users> exuser=usersRepository.findByUsername(username);
        return exuser.isPresent();
    }

    @Override
    public void saveUser(Users newUser) {
        usersRepository.save(newUser);
    }

    @Override
    public Optional<List<Users>> getusers() {
        List<Users> userList = usersRepository.findAll();
        return userList.isEmpty() ? Optional.empty() : Optional.of(userList);
    }

    @Override
    public boolean userExistsInDatabase(String username, String pass) {
        Optional<Users> xuser= usersRepository.findByUsername(username);

        Users exuser=xuser.get();
        System.out.println(exuser.getUsername());
        System.out.println(exuser.getPass());
//        if(!xuser.isPresent()) return false;
        String user=exuser.getUsername();
        String password=exuser.getPass();

        if(user.equals(username) && password.equals(pass) ){
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public String getUser(String username) {
        Optional<Users> xuser= usersRepository.findByUsername(username);
        Users exuser=xuser.get();
        String name= exuser.getName();
        return name;
    }

    @Override
    public String  addfav(String imdbId, String username) {
        if (imdbId == null || imdbId.isEmpty() || username == null || username.isEmpty()) {
            return "Invalid input";
        }

        Optional<Users> u = usersRepository.findByUsername(username);

        if (u.isPresent()) {
            Users users = u.get();
            Set<String> s = users.getFav();

            if (s == null) {
                s = new HashSet<>();
            }

            s.add(imdbId);
            users.setFav(s);
            usersRepository.save(users);
            return "Successfully added";
        } else {
            System.out.println("User is not present");
            return "User not present";
        }
    }

    @Override
    public List<String> getFav(String username) {

        System.out.println(username);
        Optional<Users> u = usersRepository.findByUsername(username);

        if(u.isPresent()){
            System.out.println("i am here");
            Users user =u.get();
            Set<String> favMovies = user.getFav();

            if (favMovies != null && !favMovies.isEmpty()) {
                return new ArrayList<>(favMovies);
            }
        }
        return Collections.emptyList();
    }

}
