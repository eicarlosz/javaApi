package com.vacina.api.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerApi extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        String messageUser = messageSource.getMessage("invalid.body", null, LocaleContextHolder.getLocale());
        String messageDev = ex.getCause().toString();
        List<Erro> erros = Arrays.asList(new Erro(messageUser, messageDev));

        return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<Erro> erros = listarErros(ex.getBindingResult());
        return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
    }

    public static class Erro {

        private String messageUser;
        private String messageDev;

        public Erro(String messageUser, String messageDev) {
            this.messageUser = messageUser;
            this.messageDev = messageDev;
        }

        public String getMessageUser() {
            return messageUser;
        }

        public String getMessageDev() {
            return messageDev;
        }

    }

    private List<Erro> listarErros(BindingResult bindingResult) {
        List<Erro> erros = new ArrayList<>();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String mensagemUser = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            String mensagemDev = fieldError.toString();
            erros.add(new Erro(mensagemUser, mensagemDev));
        }

        return erros;
    }
}
