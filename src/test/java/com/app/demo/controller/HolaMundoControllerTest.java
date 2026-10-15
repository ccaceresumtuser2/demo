package com.app.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.app.demo.dto.response.ApiResponse;
import com.app.demo.dto.response.SaludoResponse;
import com.app.demo.exception.GlobalExceptionHandler;

@ExtendWith(MockitoExtension.class)
class HolaMundoControllerTest {

    @InjectMocks
    private HolaMundoController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @Test
    void holaMundo_devuelveRespuestaEstandarConSaludo() throws Exception {
        mockMvc.perform(get("/api/v1/hola"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.saludo").value("Hola Mundo"))
                .andExpect(jsonPath("$.message").value("Operación exitosa"))
                .andExpect(jsonPath("$.httpStatus").value(200))
                .andExpect(jsonPath("$.timestamp").exists());
    }

    @Test
    void holaMundo_invocacionDirecta_devuelveOk() {
        ResponseEntity<ApiResponse<SaludoResponse>> response = controller.holaMundo();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getData().getSaludo()).isEqualTo("Hola Mundo");
        assertThat(response.getBody().getMessage()).isEqualTo("Operación exitosa");
        assertThat(response.getBody().getHttpStatus()).isEqualTo(200);
    }
}
