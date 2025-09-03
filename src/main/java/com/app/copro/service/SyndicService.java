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
        syndic.setProjet(projet);

        Syndic saved = syndicRepository.save(syndic);
        return mapToResponseDto(saved);
    }

    private SyndicResponseDto mapToResponseDto(Syndic syndic) {
        Long projetId = syndic.getProjet() != null ? syndic.getProjet().getId() : null;
        return new SyndicResponseDto(syndic.getId(), syndic.getNom(), syndic.getEmail(), projetId);
    }
}
