package com.app.copro.dto;

public class SyndicResponseDto {

    private Long id;
    private String nom;
    private String email;
    private Long projetId;

    public SyndicResponseDto() {}

    public SyndicResponseDto(Long id, String nom, String email, Long projetId) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.projetId = projetId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getProjetId() {
        return projetId;
    }

    public void setProjetId(Long projetId) {
        this.projetId = projetId;
    }
}
