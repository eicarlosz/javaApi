package com.vacina.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacina.api.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}