package com.spring.crud.repository;

import com.spring.crud.model.crayfish.Crayfish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrayfishRepository extends JpaRepository<Crayfish, Long> {
}
