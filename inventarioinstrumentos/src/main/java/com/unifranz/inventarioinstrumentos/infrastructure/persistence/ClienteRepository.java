package com.unifranz.inventarioinstrumentos.infrastructure.persistence;

import com.unifranz.inventarioinstrumentos.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByNumeroDocumento(String numeroDocumento);
}
