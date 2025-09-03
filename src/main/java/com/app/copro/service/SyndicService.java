package com.app.copro.service;

import com.app.copro.dto.CreateSyndicDto;
import com.app.copro.dto.SyndicResponseDto;
import com.app.copro.exception.ProjetNotFoundException;
import com.app.copro.model.Projet;
import com.app.copro.model.Syndic;
import com.app.copro.repository.ProjetRepository;
import com.app.copro.repository.SyndicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SyndicService {

    private final SyndicRepository syndicRepository;
    private final ProjetRepository projetRepository;

    @Autowired
    public SyndicService(SyndicRepository syndicRepository, ProjetRepository projetRepository) {
        this.syndicRepository = syndicRepository;
        this.projetRepository = projetRepository;
    }

    public SyndicResponseDto createSyndic(CreateSyndicDto createSyndicDto) {
        Projet projet = projetRepository.findByIdMakePlan(createSyndicDto.getIdMakePlan())
                .orElseThrow(() -> new ProjetNotFoundException("Projet avec idMakePlan '" + createSyndicDto.getIdMakePlan() + "' introuvable"));

        Syndic syndic = new Syndic();
        syndic.setNom(createSyndicDto.getNom());
        syndic.setEmail(createSyndicDto.getEmail());
        syndic.setTelephone(createSyndicDto.getTelephone());
        syndic.setTelecopie(createSyndicDto.getTelecopie());
        syndic.setWeb(createSyndicDto.getWeb());
        syndic.setAdresseNumeroRue(createSyndicDto.getAdresseNumeroRue());
        syndic.setAdresseComplement(createSyndicDto.getAdresseComplement());
        syndic.setAdresseCodePostal(createSyndicDto.getAdresseCodePostal());
        syndic.setAdresseVille(createSyndicDto.getAdresseVille());
        syndic.setAdresseRegion(createSyndicDto.getAdresseRegion());
        syndic.setAdressePays(createSyndicDto.getAdressePays());
        syndic.setSiret(createSyndicDto.getSiret());
        syndic.setApe(createSyndicDto.getApe());
        syndic.setCarteProfessionnelle(createSyndicDto.getCarteProfessionnelle());
        syndic.setCapital(createSyndicDto.getCapital());
        syndic.setLogoCoordonneesPath(createSyndicDto.getLogoCoordonneesPath());
        syndic.setLogoSimplePath(createSyndicDto.getLogoSimplePath());
        syndic.setPointeFinanciere(createSyndicDto.getPointeFinanciere());
        syndic.setSocieteGarant(createSyndicDto.getSocieteGarant());
        syndic.setNumeroTeleDeclarant(createSyndicDto.getNumeroTeleDeclarant());
        syndic.setMailTeleDeclarant(createSyndicDto.getMailTeleDeclarant());
        syndic.setDescription(createSyndicDto.getDescription());
        syndic.setDocCarteProfessionnellePath(createSyndicDto.getDocCarteProfessionnellePath());
        syndic.setDocAssuranceRcPath(createSyndicDto.getDocAssuranceRcPath());
        syndic.setDocGarantieFinancierePath(createSyndicDto.getDocGarantieFinancierePath());
        syndic.setDocTamponSignaturePath(createSyndicDto.getDocTamponSignaturePath());
        syndic.setProjet(projet);

        Syndic saved = syndicRepository.save(syndic);
        return mapToResponseDto(saved);
    }

    private SyndicResponseDto mapToResponseDto(Syndic syndic) {
        SyndicResponseDto dto = new SyndicResponseDto();
        dto.setId(syndic.getId());
        dto.setNom(syndic.getNom());
        dto.setEmail(syndic.getEmail());
        dto.setTelephone(syndic.getTelephone());
        dto.setTelecopie(syndic.getTelecopie());
        dto.setWeb(syndic.getWeb());
        dto.setAdresseNumeroRue(syndic.getAdresseNumeroRue());
        dto.setAdresseComplement(syndic.getAdresseComplement());
        dto.setAdresseCodePostal(syndic.getAdresseCodePostal());
        dto.setAdresseVille(syndic.getAdresseVille());
        dto.setAdresseRegion(syndic.getAdresseRegion());
        dto.setAdressePays(syndic.getAdressePays());
        dto.setSiret(syndic.getSiret());
        dto.setApe(syndic.getApe());
        dto.setCarteProfessionnelle(syndic.getCarteProfessionnelle());
        dto.setCapital(syndic.getCapital());
        dto.setLogoCoordonneesPath(syndic.getLogoCoordonneesPath());
        dto.setLogoSimplePath(syndic.getLogoSimplePath());
        dto.setPointeFinanciere(syndic.getPointeFinanciere());
        dto.setSocieteGarant(syndic.getSocieteGarant());
        dto.setNumeroTeleDeclarant(syndic.getNumeroTeleDeclarant());
        dto.setMailTeleDeclarant(syndic.getMailTeleDeclarant());
        dto.setDescription(syndic.getDescription());
        dto.setDocCarteProfessionnellePath(syndic.getDocCarteProfessionnellePath());
        dto.setDocAssuranceRcPath(syndic.getDocAssuranceRcPath());
        dto.setDocGarantieFinancierePath(syndic.getDocGarantieFinancierePath());
        dto.setDocTamponSignaturePath(syndic.getDocTamponSignaturePath());
        dto.setProjetId(syndic.getProjet() != null ? syndic.getProjet().getId() : null);
        return dto;
    }
}
