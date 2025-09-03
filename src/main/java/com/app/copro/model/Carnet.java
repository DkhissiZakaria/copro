package com.app.copro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "carnet")
public class Carnet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titre;

    @Lob
    private String contenu;

    // ManyToOne vers Syndic (existant)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "syndic_id")
    @JsonIgnore
    private Syndic syndic;

    // 1–1 Données Administratives (FK côté DonneesAdministratives)
    @OneToOne(mappedBy = "carnet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private DonneesAdministratives donneesAdministratives;

    // 1–1 Données Techniques (FK côté DonneesTechniques)
    @OneToOne(mappedBy = "carnet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private DonneesTechniques donneesTechniques;

    // 1–N Contrats d'assurance (FK côté ContratAssurance)
    @OneToMany(mappedBy = "carnet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContratAssurance> contrats = new ArrayList<>();

    // 1–N Travaux importants (FK côté TravailImportant)
    @OneToMany(mappedBy = "carnet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TravailImportant> travauxImportants = new ArrayList<>();
}
