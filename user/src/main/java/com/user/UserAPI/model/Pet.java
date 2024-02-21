package com.user.UserAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Table(name = "tblpet")
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Pet {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        private String name;
        private String breed;
        private int age;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
