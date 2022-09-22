package com.vacina.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacina.api.model.Vacina;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {

}
