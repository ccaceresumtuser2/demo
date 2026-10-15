package com.app.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.dto.response.ApiResponse;
import com.app.demo.dto.response.SaludoResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/hola")
@Tag(name = "Hola Mundo", description = "Endpoint de prueba")
public class HolaMundoController {

    @GetMapping
    @Operation(summary = "Saludo", description = "Devuelve un mensaje Hola Mundo")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Saludo exitoso")
    public ResponseEntity<ApiResponse<SaludoResponse>> holaMundo() {
        return ResponseEntity.ok(ApiResponse.success("Operación exitosa", new SaludoResponse("Hola Mundo")));
    }
}
