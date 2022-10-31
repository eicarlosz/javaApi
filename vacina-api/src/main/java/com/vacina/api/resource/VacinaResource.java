package com.vacina.api.resource;

import java.util.List;
import java.util.Optional;

import com.vacina.api.event.RecursoEvent;
import com.vacina.api.repository.filter.VacinaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vacina.api.model.Vacina;
import com.vacina.api.repository.VacinaRepository;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/vacinas")
public class VacinaResource {

    @Autowired
    private VacinaRepository vacinaRepository;

    @Autowired
    private ApplicationEventPublisher publisher;


    @GetMapping
    public List<Vacina> listarVacinas(VacinaFilter vacinaFilter) {

        return vacinaRepository.filtrar(vacinaFilter);
    }

    @PostMapping
    public ResponseEntity<Vacina> criar(@Valid @RequestBody Vacina vacina, HttpServletResponse response) {
        Vacina vacinaSalva = vacinaRepository.save(vacina);
        publisher.publishEvent(new RecursoEvent(this, response, vacinaSalva.getId_vacina()));
        return ResponseEntity.status(HttpStatus.CREATED).body(vacinaSalva);
    }

    @GetMapping("/{id_vacina}")
    public ResponseEntity<Vacina> listarVacinaLote(@PathVariable Long id_vacina) {
        Optional<Vacina> vacina = vacinaRepository.findById(id_vacina);

        return vacina.isPresent() ? ResponseEntity.ok(vacina.get()) : ResponseEntity.notFound().build();
        // devolve 404 caso busque um id que não existe
    }
}
