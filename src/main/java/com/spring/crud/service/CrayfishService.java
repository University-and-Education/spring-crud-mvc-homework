package com.spring.crud.service;

import com.spring.crud.dto.CrayfishDTO;
import com.spring.crud.model.crayfish.Crayfish;
import com.spring.crud.repository.CrayfishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrayfishService {

    private CrayfishRepository crayfishRepository;

    @Autowired
    public void setCrayfishRepository(CrayfishRepository crayfishRepository) {
        this.crayfishRepository = crayfishRepository;
    }

    public Long createCrayfish(CrayfishDTO crayfishDTO) {
        Crayfish crayfish = new Crayfish();
        crayfish.setProductName(crayfishDTO.getProductName());
        crayfish.setWeight(crayfishDTO.getWeight());
        crayfish.setCrayfishType(crayfishDTO.getCrayfishType());
        return crayfishRepository.save(crayfish).getId();
    }

    public void deleteCrayfish(Long id) {
        Crayfish crayfish = crayfishRepository.getById(id);
        crayfish.setDeleted(true);
        crayfishRepository.save(crayfish);
    }

    public CrayfishDTO findCrayfish(Long id) {
        Crayfish crayfish = crayfishRepository.getById(id);

        CrayfishDTO crayfishDTO = new CrayfishDTO();
        crayfishDTO.setProductName(crayfish.getProductName());
        crayfishDTO.setWeight(crayfish.getWeight());
        crayfishDTO.setCrayfishType(crayfish.getCrayfishType());

        return crayfishDTO;
    }

    public Long editCrayfish(Long crayfishId, CrayfishDTO crayfishDTO) {
        Crayfish crayfish = crayfishRepository.getById(crayfishId);

        if (crayfishDTO.getWeight() != null) {
            crayfish.setWeight(crayfishDTO.getWeight());
        }
        if (crayfishDTO.getProductName() != null) {
            crayfish.setProductName(crayfishDTO.getProductName());
        }
        if (crayfishDTO.getCrayfishType() != null) {
            crayfish.setCrayfishType(crayfishDTO.getCrayfishType());
        }

        return crayfishRepository.save(crayfish).getId();
    }
}