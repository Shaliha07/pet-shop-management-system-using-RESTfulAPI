package com.user.UserAPI.controller;


import com.pet.petCatalog.model.Pet;
import com.user.UserAPI.model.User;
import com.user.UserAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;




    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }


    @GetMapping("/users")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/UserByName/{name}")
    public User getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteUserById(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok(" created successfully");
    }
    @GetMapping("/{pet_id}/pets")
    public ResponseEntity<List<Pet>> getUserPets(@PathVariable Long user_id) {
        String petServiceUrl = "http://localhost:8080/api/pets/" + user_id;
        ResponseEntity<List<Pet>> response = restTemplate.exchange(
                petServiceUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Pet>>() {}
        );

        List<Pet> pets = response.getBody();
        return ResponseEntity.ok().body(pets);}


}


