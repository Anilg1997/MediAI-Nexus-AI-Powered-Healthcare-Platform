package com.aihealthcare.doctor_service.dto;

import jakarta.validation.constraints.*;

public class DoctorRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String specialization;

    @NotNull
    private Integer experience;

    @Email
    private String email;

    @NotNull
    private Boolean available;

    public String getName() {
        return name;
    }

    public void setName(
            String name) {

        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(
            String specialization) {

        this.specialization =
                specialization;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(
            Integer experience) {

        this.experience =
                experience;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(
            String email) {

        this.email = email;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(
            Boolean available) {

        this.available =
                available;
    }
}