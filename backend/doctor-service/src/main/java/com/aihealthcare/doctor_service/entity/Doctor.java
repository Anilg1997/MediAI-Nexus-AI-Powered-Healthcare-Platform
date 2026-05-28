package com.aihealthcare.doctor_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String specialization;

    private Integer experience;

    private String email;

    private Boolean available;

    public Doctor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    public void setEmail(String email) {
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