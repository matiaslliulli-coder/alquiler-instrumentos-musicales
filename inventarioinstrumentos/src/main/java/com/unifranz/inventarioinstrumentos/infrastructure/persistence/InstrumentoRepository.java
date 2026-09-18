package com.unifranz.inventarioinstrumentos.infrastructure.persistence;

import com.unifranz.inventarioinstrumentos.domain.EstadoInstrumento;
import com.unifranz.inventarioinstrumentos.domain.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstrumentoRepository extends JpaRepository<Instrumento, Long> {

    // Estos dos metodos ya quedan listos para cuando se implemente la busqueda
    // (buscar instrumentos disponibles, filtrar por categoria).
    List<Instrumento> findByEstado(EstadoInstrumento estado);

    List<Instrumento> findByCategoriaIgnoreCase(String categoria);
}
