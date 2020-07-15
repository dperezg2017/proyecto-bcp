package com.example.demo.controller.dto;

public class TipoCambioRequest {

    private Integer idMonedaOrigen;

    private Integer idMonedaDestino;

    private String descripcion;

    private Double tipo;

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
