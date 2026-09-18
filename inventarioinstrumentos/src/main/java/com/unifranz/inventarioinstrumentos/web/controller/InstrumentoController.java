package com.unifranz.inventarioinstrumentos.web.controller;

import com.unifranz.inventarioinstrumentos.domain.Instrumento;
import com.unifranz.inventarioinstrumentos.infrastructure.persistence.InstrumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// CRUD basico de Instrumento. Sirve para comprobar que la conexion a
// MySQL y el modelo de datos funcionan de punta a punta
// (Postman -> API -> JPA -> MySQL). El detalle fino (registrar en
// mantenimiento, buscar con filtros, etc.) se agrega despues, sobre
// esta misma base.
@RestController
@RequestMapping("/api/instrumentos")
public class InstrumentoController {

    @Autowired
    private InstrumentoRepository instrumentoRepository;

    @GetMapping
    public List<Instrumento> listarTodos() {
        return instrumentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrumento> buscarPorId(@PathVariable Long id) {
        return instrumentoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Instrumento registrar(@RequestBody Instrumento instrumento) {
        return instrumentoRepository.save(instrumento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instrumento> actualizar(@PathVariable Long id, @RequestBody Instrumento datos) {
        return instrumentoRepository.findById(id)
                .map(instrumento -> {
                    instrumento.setNombre(datos.getNombre());
                    instrumento.setCategoria(datos.getCategoria());
                    instrumento.setMarca(datos.getMarca());
                    instrumento.setModelo(datos.getModelo());
                    instrumento.setEstado(datos.getEstado());
                    instrumento.setPrecioAlquiler(datos.getPrecioAlquiler());
                    return ResponseEntity.ok(instrumentoRepository.save(instrumento));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!instrumentoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        instrumentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
