package com.unifranz.inventarioinstrumentos.domain;

import jakarta.persistence.*;

// Cliente que alquila instrumentos. numeroDocumento se usara mas adelante
// para la lectura automatica del carnet con AWS Textract.
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreCompleto;

    @Column(unique = true)
    private String numeroDocumento;

    private String email;

    private String telefono;

    public Cliente() {
    }

    public Cliente(String nombreCompleto, String numeroDocumento, String email, String telefono) {
        this.nombreCompleto = nombreCompleto;
        this.numeroDocumento = numeroDocumento;
        this.email = email;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
