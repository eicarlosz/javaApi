package com.vacina.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacina.api.model.Vacina;
import com.vacina.api.repository.VacinaRepository;

@RestController
@RequestMapping("/vacinas")
public class VacinaResource {

    @Autowired
    private VacinaRepository vacinaRepository;

    @GetMapping
    public List<Vacina> listarVacinas() {
        return vacinaRepository.findAll();
    }

    @GetMapping("/{id_vacina}")
    public ResponseEntity<Vacina> listarVacinaLote(@PathVariable Long id_vacina) {
        Optional<Vacina> vacina = vacinaRepository.findById(id_vacina);

        return vacina.isPresent() ? ResponseEntity.ok(vacina.get()) : ResponseEntity.notFound().build(); // devolve 404
                                                                                                         // caso busque
                                                                                                         // um id que
                                                                                                         // não existe
    }
}
