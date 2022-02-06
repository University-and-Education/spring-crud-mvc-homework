package com.spring.crud.controller;

import com.spring.crud.dto.CaviarDTO;
import com.spring.crud.repository.CaviarRepository;
import com.spring.crud.service.CaviarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
public class CaviarController {

    private CaviarService caviarService;

    private CaviarRepository caviarRepository;

    @Autowired
    public void setCaviarRepository(CaviarRepository caviarRepository) {
        this.caviarRepository = caviarRepository;
    }

    @Autowired
    public void setCaviarService(CaviarService caviarService) {
        this.caviarService = caviarService;
    }


    @GetMapping("/api/caviar/{caviarId}")
    public ResponseEntity<CaviarDTO> findCaviar(@PathVariable Long caviarId) {
        if (!caviarRepository.existsById(caviarId)) {
            throw new EntityNotFoundException("Ошибка! Товар не существует или был удален!");
        }
        return new ResponseEntity<>(caviarService.findCaviar(caviarId), HttpStatus.OK);
    }

    @PostMapping("/api/caviar")
    public ResponseEntity<Long> createCaviar(@RequestBody CaviarDTO caviarDTO) {
        return new ResponseEntity<>(caviarService.createCaviar(caviarDTO), HttpStatus.CREATED);
    }

    @PutMapping("/api/caviar/{caviarId}")
    public ResponseEntity<Long> editCaviar(@PathVariable Long caviarId, @RequestBody CaviarDTO caviarDTO) {
        if (!caviarRepository.existsById(caviarId)) {
            throw new EntityNotFoundException("Ошибка! Товар не существует или был удален!");
        }
        return new ResponseEntity<>(caviarService.editCaviar(caviarId, caviarDTO), HttpStatus.OK);
    }

    @DeleteMapping("/api/caviar/{caviarId}")
    public ResponseEntity<Void> deleteCaviar(@PathVariable Long caviarId) {
        if (!caviarRepository.existsById(caviarId) || caviarRepository.getById(caviarId).isDeleted()) {
            throw new EntityNotFoundException("Ошибка! Товар не существует или был удален!");
        }
        caviarService.deleteCaviar(caviarId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}