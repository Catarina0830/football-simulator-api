package com.catarinaklein.footballsimulator.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    // Tratamento para quando não encontrar um jogador (ID inexistente)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handle404() {
        return ResponseEntity.status(404).body("Erro: Jogador não encontrado no sistema.");
    }

    // Tratamento genérico para evitar que o cliente veja o log de erro interno
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle500(Exception ex) {
        return ResponseEntity.status(500).body("Erro interno: " + ex.getLocalizedMessage());
    }
}