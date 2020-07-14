package com.example.bcp.controller.web.dto;

public class CambioMonedaResponse {

    Double monto;
    Double montoTipoCambio;
    Integer monedaOrigen;
    Integer monedaDestino;
    Double tipoCambio;

    public CambioMonedaResponse() {
    }

    public CambioMonedaResponse(Double monto, Double montoTipoCambio, Integer monedaOrigen, Integer monedaDestino, Double tipoCambio) {
        this.monto = monto;
        this.montoTipoCambio = montoTipoCambio;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.tipoCambio = tipoCambio;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getMontoTipoCambio() {
        return montoTipoCambio;
    }

    public void setMontoTipoCambio(Double montoTipoCambio) {
        this.montoTipoCambio = montoTipoCambio;
    }

    public Integer getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(Integer monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public Integer getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(Integer monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public Double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(Double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    @Override
    public String toString() {
        return "CambioMonedaResponse{" +
                "monto=" + monto +
                ", montoTipoCambio=" + montoTipoCambio +
                ", monedaOrigen=" + monedaOrigen +
                ", monedaDestino=" + monedaDestino +
                ", tipoCambio=" + tipoCambio +
                '}';
    }
}
