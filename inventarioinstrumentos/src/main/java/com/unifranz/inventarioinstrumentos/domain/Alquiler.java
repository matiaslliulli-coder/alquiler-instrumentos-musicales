package com.unifranz.inventarioinstrumentos.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

// Registro de un alquiler: quien, que instrumento y en que plazo.
// El modulo completo (registrar, devolver, penalidad) es tarea de
// Leonardo Drew; aqui solo queda modelada la tabla.
@Entity
@Table(name = "alquiler")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "instrumento_id", nullable = false)
    private Instrumento instrumento;

    private LocalDate fechaInicio;

    private LocalDate fechaDevolucionPactada;

    private LocalDate fechaDevolucionReal;

    @Enumerated(EnumType.STRING)
    private EstadoAlquiler estado = EstadoAlquiler.ACTIVO;

    private BigDecimal penalidad = BigDecimal.ZERO;

    public Alquiler() {
    }

    public Alquiler(Cliente cliente, Instrumento instrumento, LocalDate fechaInicio, LocalDate fechaDevolucionPactada) {
        this.cliente = cliente;
        this.instrumento = instrumento;
        this.fechaInicio = fechaInicio;
        this.fechaDevolucionPactada = fechaDevolucionPactada;
        this.estado = EstadoAlquiler.ACTIVO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaDevolucionPactada() {
        return fechaDevolucionPactada;
    }

    public void setFechaDevolucionPactada(LocalDate fechaDevolucionPactada) {
        this.fechaDevolucionPactada = fechaDevolucionPactada;
    }

    public LocalDate getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public void setFechaDevolucionReal(LocalDate fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }

    public EstadoAlquiler getEstado() {
        return estado;
    }

    public void setEstado(EstadoAlquiler estado) {
        this.estado = estado;
    }

    public BigDecimal getPenalidad() {
        return penalidad;
    }

    public void setPenalidad(BigDecimal penalidad) {
        this.penalidad = penalidad;
    }
}
