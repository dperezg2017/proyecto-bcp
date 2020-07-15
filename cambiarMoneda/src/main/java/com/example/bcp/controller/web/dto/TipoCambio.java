package com.example.bcp.controller.web.dto;

import javax.persistence.*;

@Entity
@Table(name = "TIPOCAMBIO")
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ID_MONEDA_ORIGEN")
    private Integer idMonedaOrigen;

    @Column(name = "ID_MONEDA_DESTINO")
    private Integer idMonedaDestino;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "TIPO")
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
