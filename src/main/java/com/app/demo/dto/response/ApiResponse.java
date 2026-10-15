package com.app.demo.dto.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Formato estándar de respuesta de la API")
public class ApiResponse<T> {

    @Schema(description = "Fecha y hora de la respuesta", example = "2026-10-15T10:30:00")
    private LocalDateTime timestamp;

    @Schema(description = "Contenido de la respuesta")
    private T data;

    @Schema(description = "Mensaje descriptivo", example = "Operación exitosa")
    private String message;

    @Schema(description = "Código de estado HTTP", example = "200")
    private int httpStatus;

    public ApiResponse(T data, String message, HttpStatus httpStatus) {
        this.timestamp = LocalDateTime.now();
        this.data = data;
        this.message = message;
        this.httpStatus = httpStatus.value();
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(data, message, HttpStatus.OK);
    }

    public static <T> ApiResponse<T> error(String message, HttpStatus httpStatus) {
        return new ApiResponse<>(null, message, httpStatus);
    }

    // Getters and Setters
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public int getHttpStatus() { return httpStatus; }
    public void setHttpStatus(int httpStatus) { this.httpStatus = httpStatus; }
}
