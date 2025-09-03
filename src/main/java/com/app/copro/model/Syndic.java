package com.app.copro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "syndic")
public class Syndic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ===== Détail du Syndic =====
    @Column(nullable = false, length = 120)
    private String nom;


    @Column(nullable = false, length = 150)
    private String email;

    @Column(length = 50)
    private String telephone;

    @Column(length = 50)
    private String telecopie; // fax

    @Column(length = 255)
    private String web; // url

    // ===== Adresse =====
    @Column(length = 180)
    private String adresseNumeroRue;   // N° et rue

    @Column(length = 180)
    private String adresseComplement;  // Complément

    @Column(length = 20)
    private String adresseCodePostal;

    @Column(length = 120)
    private String adresseVille;

    @Column(length = 120)
    private String adresseRegion;

    @Column(length = 120)
    private String adressePays;

    // ===== Informations juridiques =====
    @Column(length = 20)
    private String siret;

    @Column(length = 20)
    private String ape;

    @Column(length = 120)
    private String carteProfessionnelle; // n°/référence

    // Capital : string pour tolérer formats non strictement numériques
    @Column(length = 50)
    private String capital;

    // Logos (stockage simple : chemin/URL du fichier)
    @Column(length = 255)
    private String logoCoordonneesPath; // 510x260

    @Column(length = 255)
    private String logoSimplePath;      // signature mail

    // ===== Garantie Financière =====
    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal pointeFinanciere = BigDecimal.ZERO;

    @Column(length = 120)
    private String societeGarant;

    // ===== Registre Copropriété =====
    @Column(length = 50)
    private String numeroTeleDeclarant;

    @Column(length = 150)
    private String mailTeleDeclarant;

    // ===== Description =====
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    // ===== Documents (uploads : chemins/URLs) =====
    @Column(length = 255)
    private String docCarteProfessionnellePath;

    @Column(length = 255)
    private String docAssuranceRcPath; // attestation RC pro

    @Column(length = 255)
    private String docGarantieFinancierePath; // attestation GF

    @Column(length = 255)
    private String docTamponSignaturePath; // tampon + signature

    // ===== Relations existantes =====

    // ManyToOne vers Projet
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "projet_id")
    @JsonIgnore
    private Projet projet;

    // OneToOne avec Mandat (Mandat est propriétaire)
    @OneToOne(mappedBy = "syndic", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Mandat mandat;

    // Syndic (1) -> (N) Carnet
    @OneToMany(mappedBy = "syndic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carnet> carnets = new ArrayList<>();

    // ===== Getters/Setters =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getTelecopie() { return telecopie; }
    public void setTelecopie(String telecopie) { this.telecopie = telecopie; }

    public String getWeb() { return web; }
    public void setWeb(String web) { this.web = web; }

    public String getAdresseNumeroRue() { return adresseNumeroRue; }
    public void setAdresseNumeroRue(String adresseNumeroRue) { this.adresseNumeroRue = adresseNumeroRue; }

    public String getAdresseComplement() { return adresseComplement; }
    public void setAdresseComplement(String adresseComplement) { this.adresseComplement = adresseComplement; }

    public String getAdresseCodePostal() { return adresseCodePostal; }
    public void setAdresseCodePostal(String adresseCodePostal) { this.adresseCodePostal = adresseCodePostal; }

    public String getAdresseVille() { return adresseVille; }
    public void setAdresseVille(String adresseVille) { this.adresseVille = adresseVille; }

    public String getAdresseRegion() { return adresseRegion; }
    public void setAdresseRegion(String adresseRegion) { this.adresseRegion = adresseRegion; }

    public String getAdressePays() { return adressePays; }
    public void setAdressePays(String adressePays) { this.adressePays = adressePays; }

    public String getSiret() { return siret; }
    public void setSiret(String siret) { this.siret = siret; }

    public String getApe() { return ape; }
    public void setApe(String ape) { this.ape = ape; }

    public String getCarteProfessionnelle() { return carteProfessionnelle; }
    public void setCarteProfessionnelle(String carteProfessionnelle) { this.carteProfessionnelle = carteProfessionnelle; }

    public String getCapital() { return capital; }
    public void setCapital(String capital) { this.capital = capital; }

    public String getLogoCoordonneesPath() { return logoCoordonneesPath; }
    public void setLogoCoordonneesPath(String logoCoordonneesPath) { this.logoCoordonneesPath = logoCoordonneesPath; }

    public String getLogoSimplePath() { return logoSimplePath; }
    public void setLogoSimplePath(String logoSimplePath) { this.logoSimplePath = logoSimplePath; }

    public BigDecimal getPointeFinanciere() { return pointeFinanciere; }
    public void setPointeFinanciere(BigDecimal pointeFinanciere) {
        this.pointeFinanciere = (pointeFinanciere != null) ? pointeFinanciere : BigDecimal.ZERO;
    }

    public String getSocieteGarant() { return societeGarant; }
    public void setSocieteGarant(String societeGarant) { this.societeGarant = societeGarant; }

    public String getNumeroTeleDeclarant() { return numeroTeleDeclarant; }
    public void setNumeroTeleDeclarant(String numeroTeleDeclarant) { this.numeroTeleDeclarant = numeroTeleDeclarant; }

    public String getMailTeleDeclarant() { return mailTeleDeclarant; }
    public void setMailTeleDeclarant(String mailTeleDeclarant) { this.mailTeleDeclarant = mailTeleDeclarant; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDocCarteProfessionnellePath() { return docCarteProfessionnellePath; }
    public void setDocCarteProfessionnellePath(String docCarteProfessionnellePath) { this.docCarteProfessionnellePath = docCarteProfessionnellePath; }

    public String getDocAssuranceRcPath() { return docAssuranceRcPath; }
    public void setDocAssuranceRcPath(String docAssuranceRcPath) { this.docAssuranceRcPath = docAssuranceRcPath; }

    public String getDocGarantieFinancierePath() { return docGarantieFinancierePath; }
    public void setDocGarantieFinancierePath(String docGarantieFinancierePath) { this.docGarantieFinancierePath = docGarantieFinancierePath; }

    public String getDocTamponSignaturePath() { return docTamponSignaturePath; }
    public void setDocTamponSignaturePath(String docTamponSignaturePath) { this.docTamponSignaturePath = docTamponSignaturePath; }

    public Projet getProjet() { return projet; }
    public void setProjet(Projet projet) { this.projet = projet; }

    public Mandat getMandat() { return mandat; }
    public void setMandat(Mandat mandat) { this.mandat = mandat; }

    public List<Carnet> getCarnets() { return carnets; }
    public void setCarnets(List<Carnet> carnets) { this.carnets = carnets; }
}
