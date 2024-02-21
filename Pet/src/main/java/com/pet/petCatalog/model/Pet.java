package com.pet.petCatalog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Table(name = "tblpet")
@Entity
@NoArgsConstructor


public class Pet {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

    public User getUser() {
        return user;
    }

    public Pet(long id, String name, String breed, int age, User user) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private String name;
        private String breed;
        private int age;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_Id")
    private User user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
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
