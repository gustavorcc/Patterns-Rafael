package com.unicesumar.entities;

import java.util.UUID;

public class User extends Entity {
    public User(UUID uuid, String name, String email, String password) {
        super(uuid);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    private final String name;
    private final String email;
    private final String password;


    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void ToString(){
        System.out.println("Usuário: " + this.name
        + "\nEmail: " + this.email + "\n\n");
    }

}
