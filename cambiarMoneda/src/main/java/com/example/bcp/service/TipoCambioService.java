package com.example.bcp.service;

import com.example.bcp.controller.web.dto.CambioMonedaResponse;
import com.example.bcp.controller.web.dto.TipoCambio;

public interface TipoCambioService {
    CambioMonedaResponse aplicarCambioYml(Double monto, String monedaOrigen, String monedaDestino);

    CambioMonedaResponse aplicarCambio(Double monto, String monedaOrigen, String monedaDestino);

    TipoCambio agregarTipoCambio(TipoCambio tipoCambio);

    Double obtenerTipoCambio(String monedaOrigen, String monedaDestino);
}
