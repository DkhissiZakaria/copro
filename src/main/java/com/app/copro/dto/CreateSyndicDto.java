package com.app.copro.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateSyndicDto {

    @NotBlank(message = "Le nom du syndic ne peut pas être vide")
    @Size(max = 120, message = "Le nom du syndic ne peut pas dépasser 120 caractères")
    private String nom;

    @NotBlank(message = "L'email du syndic ne peut pas être vide")
    @Email(message = "Email invalide")
    private String email;

    @NotNull(message = "idMakePlan est requis")
    private Long idMakePlan;

    public CreateSyndicDto() {}

    public CreateSyndicDto(String nom, String email, Long idMakePlan) {
        this.nom = nom;
        this.email = email;
        this.idMakePlan = idMakePlan;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdMakePlan() {
        return idMakePlan;
    }

    public void setIdMakePlan(Long idMakePlan) {
        this.idMakePlan = idMakePlan;
    }
}
