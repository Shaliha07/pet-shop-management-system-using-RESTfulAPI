package com.pet.petCatalog.Dto;

import jakarta.persistence.Table;

@Table(name = "tbluserDetails")
public class PetDTO {
    private Long petId;
    private String petName;

    public Long getPetId() {
        return petId;
    }

    public PetDTO() {
    }

    public PetDTO(Long petId, String petName, String petBreed, int petAge, Long userId, String username, String userEmail) {
        this.petId = petId;
        this.petName = petName;
        this.petBreed = petBreed;
        this.petAge = petAge;
        this.userId = userId;
        this.username = username;
        this.userEmail = userEmail;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    private String petBreed;
    private int petAge;

    private Long userId;
    private String username;
    private String userEmail;


}
