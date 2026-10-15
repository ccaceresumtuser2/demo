package com.app.demo.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos del saludo")
public class SaludoResponse {

    @Schema(description = "Mensaje de saludo", example = "Hola Mundo")
    private String saludo;

    public SaludoResponse(String saludo) {
        this.saludo = saludo;
    }

    // Getters and Setters
    public String getSaludo() { return saludo; }
    public void setSaludo(String saludo) { this.saludo = saludo; }
}
