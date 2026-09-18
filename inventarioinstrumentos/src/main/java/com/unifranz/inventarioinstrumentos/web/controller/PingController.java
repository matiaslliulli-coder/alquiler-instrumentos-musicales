package com.unifranz.inventarioinstrumentos.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Endpoint simple para verificar que el backend arranco bien,
// sin necesidad de tocar la base de datos. Es el primer request
// que deberias probar en Postman.
@RestController
public class PingController {

    @GetMapping("/api/ping")
    public String ping() {
        return "El backend esta funcionando correctamente.";
    }
}
