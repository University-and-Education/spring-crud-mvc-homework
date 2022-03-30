package com.spring.crud.service;

import com.spring.crud.dto.OctopusDTO;
import com.spring.crud.model.octopus.Octopus;
import com.spring.crud.repository.OctopusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OctopusService {

    private OctopusRepository octopusRepository;

    @Autowired
    public void setOctopusRepository(OctopusRepository octopusRepository) {
        this.octopusRepository = octopusRepository;
    }

    public Long createOctopus(OctopusDTO octopusDTO) {
        Octopus octopus = new Octopus();
        octopus.setProductName(octopusDTO.getProductName());
        octopus.setWeight(octopusDTO.getWeight());
        octopus.setPeeled(octopusDTO.isPeeled());
        return octopusRepository.save(octopus).getId();
    }

    public void deleteOctopus(Long id) {
        Octopus octopus = octopusRepository.getById(id);
        octopus.setDeleted(true);
        octopusRepository.save(octopus);
    }

    public OctopusDTO findOctopus(Long id) {
        Octopus octopus = octopusRepository.getById(id);

        OctopusDTO octopusDTO = new OctopusDTO();
        octopusDTO.setProductName(octopus.getProductName());
        octopusDTO.setWeight(octopus.getWeight());
        octopusDTO.setPeeled(octopusDTO.isPeeled());

        return octopusDTO;
    }

    public Long editOctopus(Long octopusId, OctopusDTO octopusDTO) {
        Octopus octopus = octopusRepository.getById(octopusId);

        if (octopusDTO.getWeight() != null) {
            octopus.setWeight(octopusDTO.getWeight());
        }
        if (octopusDTO.getProductName() != null) {
            octopus.setProductName(octopusDTO.getProductName());
        }
        if (octopusDTO.isPeeled()) {
            octopus.setPeeled(octopusDTO.isPeeled());
        }

        return octopusRepository.save(octopus).getId();
    }
}