package com.app.copro.controller;

import com.app.copro.dto.CreateSyndicDto;
import com.app.copro.dto.SyndicResponseDto;
import com.app.copro.service.SyndicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
