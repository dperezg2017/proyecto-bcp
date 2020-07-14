package com.example.bcp.controller.web.dto;

import javax.persistence.*;

@Entity
@Table(name = "tipocambio")
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "idMonedaOrigen")
    private Integer idMonedaOrigen;

    @Column(name = "idMonedaDestino")
    private Integer idMonedaDestino;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo")
    private Double tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMonedaOrigen() {
        return idMonedaOrigen;
    }

    public void setIdMonedaOrigen(Integer idMonedaOrigen) {
        this.idMonedaOrigen = idMonedaOrigen;
    }

    public Integer getIdMonedaDestino() {
        return idMonedaDestino;
    }

    public void setIdMonedaDestino(Integer idMonedaDestino) {
        this.idMonedaDestino = idMonedaDestino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getTipo() {
        return tipo;
    }

    public void setTipo(Double tipo) {
        this.tipo = tipo;
    }
}
