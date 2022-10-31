package com.vacina.api.event.listener;

import com.vacina.api.event.RecursoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class RecursoListener implements ApplicationListener<RecursoEvent> {

    @Override
    public void onApplicationEvent(RecursoEvent recursoEvent) {
        HttpServletResponse response = recursoEvent.getResponse();
        Long idVacina = recursoEvent.getIdVacina();

        adicionarHeaderLocation(response, idVacina);
    }

    private void adicionarHeaderLocation(HttpServletResponse response, Long idVacina) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id_vacina}")
                .buildAndExpand(idVacina).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }

}
