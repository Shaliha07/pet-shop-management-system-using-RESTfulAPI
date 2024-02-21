package com.pet.petCatalog.repository;

import org.apache.catalina.User;

import java.util.List;

public interface PetRepositoryimpl {

    List<User> getUsersWithPets();
}
