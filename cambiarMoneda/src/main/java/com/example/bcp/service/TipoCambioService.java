package com.example.bcp.service;

import com.example.bcp.controller.web.dto.CambioMonedaResponse;
import com.example.bcp.controller.web.dto.TipoCambio;
import io.reactivex.Single;

public interface TipoCambioService {
    CambioMonedaResponse aplicarCambioYml(Double monto, String monedaOrigen, String monedaDestino);

    CambioMonedaResponse aplicarCambio(Double monto, String monedaOrigen, String monedaDestino);

    Single<TipoCambio> agregarTipoCambio(TipoCambio tipoCambio);

    Single<Double> obtenerTipoCambio(String monedaOrigen, String monedaDestino);
}
