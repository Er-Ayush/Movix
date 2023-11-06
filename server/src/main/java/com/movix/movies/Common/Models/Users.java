package com.movix.movies.Common.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "Users")
public class Users {


    @Id
    private String username;

    private String name;
    private String pass;

    List<String> fav;

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<String> getFav() {
        return fav;
    }

    public void setFav(List<String> fav) {
        this.fav = fav;
    }

    public Users(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public Users(String username, String pass, List<String> fav) {
        this.username = username;
        this.pass = pass;
        this.fav = fav;
    }

    public Users() {
    }
}
