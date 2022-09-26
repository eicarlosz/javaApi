package com.vacina.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vacina.api.model.Paciente;
import com.vacina.api.repository.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteResource {

    @Autowired
    private PacienteRepository usuarioRepository;

    @GetMapping // Anotação e metodo que busca todos os registros
    public List<Paciente> listarUsers() {
        return usuarioRepository.findAll();
    }

    @PostMapping // Anotação e metodo que insere um novo registro metodo Post
    public ResponseEntity<Paciente> criar(@Valid @RequestBody Paciente paciente, HttpServletResponse response) {
        Paciente userSave = usuarioRepository.save(paciente);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(userSave.getId_paciente()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(userSave);
    }

    @GetMapping("/{id}") // Anotação e metodo que busca pelo id metodo get
    public ResponseEntity<Paciente> listarUserId(@PathVariable Long id) {
        Optional<Paciente> paciente = usuarioRepository.findById(id);

        return paciente.isPresent() ? ResponseEntity.ok(paciente.get()) : ResponseEntity.notFound().build();
        // devolve 404 caso busque um id que não existe
    }

}