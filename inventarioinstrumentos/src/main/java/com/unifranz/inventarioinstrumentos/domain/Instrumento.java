package com.unifranz.inventarioinstrumentos.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

// Instrumento musical del catalogo. Pertenece a una Tienda y tiene un precio
// de alquiler propio en esa sucursal (RF04: comparar precios entre tiendas).
@Entity
@Table(name = "instrumento")
public class Instrumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String categoria;

    private String marca;

    private String modelo;

    @Enumerated(EnumType.STRING)
    private EstadoInstrumento estado = EstadoInstrumento.DISPONIBLE;

    private BigDecimal precioAlquiler;

    @ManyToOne
    @JoinColumn(name = "tienda_id")
    private Tienda tienda;

    public Instrumento() {
    }

    public Instrumento(String nombre, String categoria, String marca, String modelo,
                        BigDecimal precioAlquiler, Tienda tienda) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.marca = marca;
        this.modelo = modelo;
        this.precioAlquiler = precioAlquiler;
        this.tienda = tienda;
        this.estado = EstadoInstrumento.DISPONIBLE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public EstadoInstrumento getEstado() {
        return estado;
    }

    public void setEstado(EstadoInstrumento estado) {
        this.estado = estado;
    }

    public BigDecimal getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(BigDecimal precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}
