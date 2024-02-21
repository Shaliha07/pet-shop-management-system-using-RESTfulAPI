package com.pet.petCatalog.service;

import com.pet.petCatalog.Dto.PetDTO;
import com.pet.petCatalog.model.Pet;
import com.pet.petCatalog.model.User;
import com.pet.petCatalog.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Pet savePet(Pet pet) {

        return petRepository.save(pet);
    }

    public Pet getPet(long pet) {

        return petRepository.findById(pet).orElse(null);
    }

    public List<Pet> getAllPet() {

        return petRepository.findAll();
    }

    public Pet getPetByName(String name) {

        return petRepository.findbyName(name);
    }

    public String deletePet(long pet) {
        petRepository.deleteById(pet);
        if (petRepository.findById(pet).isPresent()) {
            return "Not Deleted";
        } else {
            return "Deleted";
        }

    }

    public List<Pet> getPetsByUserId(Long user_id) {
        return petRepository.findByUserId(user_id);
    }

    public Pet getPetById(Long petId) {
        return petRepository.findById(petId).orElse(null);
    }

    public List<PetDTO> getPetsWithUserDetails() {
        return petRepository.findAll().stream()
                .map(pet -> {
                    PetDTO petDTO = new PetDTO();
                    petDTO.setPetId(pet.getId());
                    petDTO.setPetName(pet.getName());
                    petDTO.setPetBreed(pet.getBreed());
                    petDTO.setPetAge(pet.getAge());

                    if (pet.getUser() != null) {
                        petDTO.setUserId(pet.getUser().getId());
                        petDTO.setUsername(pet.getUser().getName());
                        petDTO.setUserEmail(pet.getUser().getEmail());
                    }

                    return petDTO;
                })
                .collect(Collectors.toList());
    }



}
