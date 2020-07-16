package com.example.bcp.repository;


import com.example.bcp.controller.web.dto.TipoCambio;

public interface TipoCambioRepository  {
    Double obtenerTipoCambio(String monedaOrigen, String monedaDestino);
    Integer actualizarTipoCambio(TipoCambio tipoCambio);
}
