package com.user.UserAPI.service;
import com.pet.petCatalog.model.Pet;
import com.pet.petCatalog.repository.PetRepository;
import com.pet.petCatalog.service.PetService;
import com.user.UserAPI.repository.UserRepository;
import com.user.UserAPI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser() {


        return userRepository.findAll();
    }

    public User getUserByName(String name) {
        return userRepository.findbyName(name);
    }

    public String deleteUser(int userId) {
        userRepository.deleteById((long) userId);

        if (userRepository.findById((long) userId).isPresent()) {
            return "Not Deleted";
        } else {
            return "Deleted";
        }
    }
    public User createUser(User user) {

        return userRepository.save(user);
    }
    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Pet> getUserPets(Long userId) {
        String petServiceUrl = "http://localhost:8080/api/pets/" + userId;

        ResponseEntity<List<Pet>> response = restTemplate.exchange(
                petServiceUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Pet>>() {}
        );

        return response.getBody();
    }



}
