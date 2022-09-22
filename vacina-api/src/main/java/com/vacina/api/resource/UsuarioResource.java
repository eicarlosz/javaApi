package com.vacina.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vacina.api.model.Usuario;
import com.vacina.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping // Anotação e metodo que busca todos os registros
    public List<Usuario> listarUsers() {
        return usuarioRepository.findAll();
    }

    @PostMapping // Anotação e metodo que insere um novo registro metodo Post
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario, HttpServletResponse response) {
        Usuario userSave = usuarioRepository.save(usuario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(userSave.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(userSave);
    }

    @GetMapping("/{id}") // Anotação e metodo que busca pelo id metodo get
    public ResponseEntity<Usuario> listarUserId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        return usuario.isPresent() ? ResponseEntity.ok(usuario.get()) : ResponseEntity.notFound().build(); // devolve
                                                                                                           // 404 caso
                                                                                                           // busque um
                                                                                                           // id que não
                                                                                                           // existe
    }

}