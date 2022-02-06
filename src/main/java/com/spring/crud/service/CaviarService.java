package com.spring.crud.service;

import com.spring.crud.dto.CaviarDTO;
import com.spring.crud.model.caviar.Caviar;
import com.spring.crud.repository.CaviarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaviarService {

    private CaviarRepository caviarRepository;

    @Autowired
    public void setCaviarRepository(CaviarRepository caviarRepository) {
        this.caviarRepository = caviarRepository;
    }

    public Long createCaviar(CaviarDTO caviarDTO) {
        Caviar caviar = new Caviar();
        caviar.setProductName(caviarDTO.getProductName());
        caviar.setWeight(caviarDTO.getWeight());
        caviar.setCaviarColor(caviarDTO.getCaviarColor());
        caviar.setArtificial(caviarDTO.isArtificial());
        caviar.setFish(caviarDTO.getFish());

        return caviarRepository.save(caviar).getId();
    }

    public void deleteCaviar(Long id) {
        Caviar caviar = caviarRepository.getById(id);
        caviar.setDeleted(true);
        caviarRepository.save(caviar);
    }

    public CaviarDTO findCaviar(Long id) {
        Caviar caviar = caviarRepository.getById(id);

        CaviarDTO caviarDTO = new CaviarDTO();
        caviarDTO.setProductName(caviar.getProductName());
        caviarDTO.setWeight(caviar.getWeight());
        caviarDTO.setArtificial(caviar.isArtificial());
        caviarDTO.setFish(caviar.getFish());
        caviarDTO.setCaviarColor(caviar.getCaviarColor());

        return caviarDTO;
    }

    public Long editCaviar(Long caviarId, CaviarDTO caviarDTO) {
        Caviar caviar = caviarRepository.getById(caviarId);

        if (caviarDTO.getWeight() != null) {
            caviar.setWeight(caviarDTO.getWeight());
        }
        if (caviarDTO.getProductName() != null) {
            caviar.setProductName(caviarDTO.getProductName());
        }
        if (caviarDTO.isArtificial() != null) {
            caviar.setArtificial(caviarDTO.isArtificial());
        }
        if (caviarDTO.getFish() != null) {
            caviar.setFish(caviarDTO.getFish());
        }
        if (caviarDTO.getCaviarColor() != null) {
            caviar.setCaviarColor(caviarDTO.getCaviarColor());
        }

        return caviarRepository.save(caviar).getId();
    }
}