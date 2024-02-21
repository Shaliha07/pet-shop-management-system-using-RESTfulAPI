package com.pet.petCatalog.repository;

import com.pet.petCatalog.Dto.PetDTO;
import com.pet.petCatalog.model.Pet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet,Long>, PetRepositoryimpl {

    @Query("SELECT e FROM Pet e WHERE e.name = :name")
    Pet findbyName(@Param("name") String name);
    @PersistenceContext
    EntityManager entityManager = null;
    List<Pet> findByUserId(Long userId);
    @Override
    @Query("SELECT p FROM Pet p WHERE p.user IS NOT NULL")
    List<User> getUsersWithPets();

    @Query("SELECT p FROM Pet p JOIN FETCH p.user WHERE p.id = :petId")
    Pet findByIdWithUser(@Param("petId") Long petId);

    @Query("SELECT new com.pet.petCatalog.Dto.PetDTO(p.id, p.name, p.breed, p.age, u.id, u.name, u.email) FROM Pet p JOIN p.user u")
    List<PetDTO> findAllPetsWithUserDetails();






}
