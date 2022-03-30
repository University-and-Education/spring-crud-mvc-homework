package com.spring.crud.controller;

import com.spring.crud.dto.CrayfishDTO;
import com.spring.crud.exception.EntityNotFoundException;
import com.spring.crud.repository.CrayfishRepository;
import com.spring.crud.service.CrayfishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CrayfishController {

    private CrayfishService crayfishService;

    private CrayfishRepository crayfishRepository;

    @Autowired
    public void setCrayfishRepository(CrayfishRepository crayfishRepository) {
        this.crayfishRepository = crayfishRepository;
    }

    @Autowired
    public void setCrayfishService(CrayfishService crayfishService) {
        this.crayfishService = crayfishService;
    }


    @GetMapping("/api/crayfish/{crayfishId}")
    public ResponseEntity<CrayfishDTO> findCrayfish(@PathVariable Long crayfishId) {
        if (!crayfishRepository.existsById(crayfishId)) {
            throw new EntityNotFoundException("Ошибка! Товар не существует или был удален!");
        }
        return new ResponseEntity<>(crayfishService.findCrayfish(crayfishId), HttpStatus.OK);
    }

    @PostMapping("/api/crayfish")
    public ResponseEntity<Long> createCrayfish(@RequestBody CrayfishDTO crayfishDTO) {
        return new ResponseEntity<>(crayfishService.createCrayfish(crayfishDTO), HttpStatus.CREATED);
    }

    @PutMapping("/api/crayfish/{crayfishId}")
    public ResponseEntity<Long> editCrayfish(@PathVariable Long crayfishId, @RequestBody CrayfishDTO crayfishDTO) {
        if (!crayfishRepository.existsById(crayfishId)) {
            throw new EntityNotFoundException("Ошибка! Товар не существует или был удален!");
        }
        return new ResponseEntity<>(crayfishService.editCrayfish(crayfishId, crayfishDTO), HttpStatus.OK);
    }

    @DeleteMapping("/api/crayfish/{crayfishId}")
    public ResponseEntity<Void> deleteCrayfish(@PathVariable Long crayfishId) {
        if (!crayfishRepository.existsById(crayfishId) || crayfishRepository.getById(crayfishId).isDeleted()) {
            throw new EntityNotFoundException("Ошибка! Товар не существует или был удален!");
        }
        crayfishService.deleteCrayfish(crayfishId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
