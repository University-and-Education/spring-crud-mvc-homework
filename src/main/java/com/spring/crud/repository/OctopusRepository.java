package com.spring.crud.repository;

import com.spring.crud.model.octopus.Octopus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OctopusRepository extends JpaRepository<Octopus, Long> {
}