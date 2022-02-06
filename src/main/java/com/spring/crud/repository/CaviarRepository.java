package com.spring.crud.repository;

import com.spring.crud.model.caviar.Caviar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaviarRepository extends JpaRepository<Caviar, Long> {

}