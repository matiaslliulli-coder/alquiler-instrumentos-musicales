package com.unifranz.inventarioinstrumentos.infrastructure.persistence;

import com.unifranz.inventarioinstrumentos.domain.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiendaRepository extends JpaRepository<Tienda, Long> {
}
