package com.spring.crud.controller;

import com.spring.crud.dto.OctopusDTO;
import com.spring.crud.exception.EntityNotFoundException;
import com.spring.crud.repository.OctopusRepository;
import com.spring.crud.service.OctopusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OctopusController {

    private OctopusService octopusService;

    private OctopusRepository octopusRepository;

    @Autowired
    public void setOctopusRepository(OctopusRepository octopusRepository) {
        this.octopusRepository = octopusRepository;
    }

    @Autowired
    public void setOctopusService(OctopusService octopusService) {
        this.octopusService = octopusService;
    }


    @GetMapping("/api/octopus/{octopusId}")
    public ResponseEntity<OctopusDTO> findOctopus(@PathVariable Long octopusId) {
        if (!octopusRepository.existsById(octopusId)) {
            throw new EntityNotFoundException("Ошибка! Товар не существует или был удален!");
        }
        return new ResponseEntity<>(octopusService.findOctopus(octopusId), HttpStatus.OK);
    }

    @PostMapping("/api/octopus")
    public ResponseEntity<Long> createOctopus(@RequestBody OctopusDTO octopusDTO) {
        return new ResponseEntity<>(octopusService.createOctopus(octopusDTO), HttpStatus.CREATED);
    }

    @PutMapping("/api/octopus/{octopusId}")
    public ResponseEntity<Long> editOctopus(@PathVariable Long octopusId, @RequestBody OctopusDTO octopusDTO) {
        if (!octopusRepository.existsById(octopusId)) {
            throw new EntityNotFoundException("Ошибка! Товар не существует или был удален!");
        }
        return new ResponseEntity<>(octopusService.editOctopus(octopusId, octopusDTO), HttpStatus.OK);
    }

    @DeleteMapping("/api/octopus/{octopusId}")
    public ResponseEntity<Void> deleteOctopus(@PathVariable Long octopusId) {
        if (!octopusRepository.existsById(octopusId) || octopusRepository.getById(octopusId).isDeleted()) {
            throw new EntityNotFoundException("Ошибка! Товар не существует или был удален!");
        }
        octopusService.deleteOctopus(octopusId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}