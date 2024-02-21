package com.pet.petCatalog.controller;

import com.pet.petCatalog.Dto.PetDTO;
import com.pet.petCatalog.model.Pet;

import com.pet.petCatalog.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    @Autowired
    private PetService petService;



    @PostMapping("/savePet")
    public Pet savePet(@RequestBody Pet pet){
        return petService.savePet(pet);
    }

    @GetMapping("pet/{pet_id}")
    public Pet getPet(@PathVariable int pet_id){
        return petService.getPet(pet_id);
    }

    @GetMapping("/pets")
    public List<Pet> getAllPet(){
        return petService.getAllPet();
    }

    @GetMapping("petByName/{name}")
    public Pet getPetByName(@PathVariable String name){
        return petService.getPetByName(name);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deletePetById(@PathVariable int id){
        return petService.deletePet(id);
    }

    @GetMapping("/pets/pets")
    public ResponseEntity<List<Pet>> getPetsByUserId(@RequestParam Long user_id) {
        List<Pet> pets = petService.getPetsByUserId(user_id);
        return ResponseEntity.ok().body(pets);
    }

    @GetMapping("/{user_id}/pets/{pet_id}")
    public ResponseEntity<Pet> getUserPet(@PathVariable Long user_id, @PathVariable Long pet_id) {

        Pet pet = petService.getPetById(pet_id);

        if (pet != null) {
            return ResponseEntity.ok(pet);
        } else {
            return ResponseEntity.notFound().build();
        }}
    @GetMapping("/withUserDetails")
    public ResponseEntity<List<PetDTO>> getPetsWithUserDetails() {
        List<PetDTO> petsWithUserDetails = petService.getPetsWithUserDetails();
        return ResponseEntity.ok(petsWithUserDetails);
    }





}

