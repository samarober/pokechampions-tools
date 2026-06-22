package com.pokechampionstools.backend.domain.exception;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiError> handleNotFound(NoSuchElementException ex) {
        ApiError error = new ApiError(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneralException(Exception ex) throws NoResourceFoundException {

        // 1. ESTO ES LO MÁS IMPORTANTE: imprime el error completo en tu consola de IntelliJ
        ex.printStackTrace();

        // 2. Dejamos pasar los errores de recursos no encontrados (404)
        if (ex instanceof NoResourceFoundException) {
            throw (NoResourceFoundException) ex;
        }

        // 3. Para depurar, vamos a devolver el mensaje real del error en lugar de uno genérico
        // Esto hará que Postman te diga exactamente qué línea está fallando
        String mensajeReal = ex.getMessage() != null ? ex.getMessage() : "Error interno desconocido";

        ApiError error = new ApiError(500, mensajeReal, LocalDateTime.now());
        return ResponseEntity.status(500).body(error);
    }
}