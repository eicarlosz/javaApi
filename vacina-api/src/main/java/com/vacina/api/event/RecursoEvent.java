package com.vacina.api.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class RecursoEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;

    private HttpServletResponse response;
    private Long idVacina;

    public RecursoEvent(Object source, HttpServletResponse response, Long idVacina) {
        super(source);
        this.response = response;
        this.idVacina = idVacina;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public Long getIdVacina() {
        return idVacina;
    }

}
