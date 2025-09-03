package com.app.copro.controller;

import com.app.copro.dto.CreateSyndicDto;
import com.app.copro.dto.SyndicResponseDto;
import com.app.copro.dto.UpdateSyndicDto;
import com.app.copro.service.SyndicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/syndics")
@CrossOrigin(origins = "*")
public class SyndicController {

    private final SyndicService syndicService;

    @Autowired
    public SyndicController(SyndicService syndicService) {
        this.syndicService = syndicService;
    }

    @PostMapping
    public ResponseEntity<SyndicResponseDto> createSyndic(@Valid @RequestBody CreateSyndicDto createSyndicDto) {
        SyndicResponseDto response = syndicService.createSyndic(createSyndicDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SyndicResponseDto> getSyndicById(@PathVariable Long id) {
        SyndicResponseDto response = syndicService.getSyndicById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SyndicResponseDto> updateSyndic(@PathVariable Long id, @Valid @RequestBody UpdateSyndicDto updateSyndicDto) {
        SyndicResponseDto response = syndicService.updateSyndic(id, updateSyndicDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/by-makeplan/{idMakePlan}")
    public ResponseEntity<List<SyndicResponseDto>> getSyndicsByIdMakePlan(@PathVariable Long idMakePlan) {
        try {
            List<SyndicResponseDto> response = syndicService.getSyndicsByIdMakePlan(idMakePlan);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log l'erreur au niveau contrôleur aussi
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
