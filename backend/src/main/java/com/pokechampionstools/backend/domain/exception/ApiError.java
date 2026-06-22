package com.pokechampionstools.backend.domain.exception;

import java.time.LocalDateTime;

public record ApiError(int statusCode, String message, LocalDateTime timestamp) {

    // Este constructor permite crear el error sin pasar la fecha manualmente
    public ApiError(int statusCode, String message) {
        this(statusCode, message, LocalDateTime.now());
    }
}