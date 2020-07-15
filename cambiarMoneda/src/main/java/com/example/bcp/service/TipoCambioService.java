package com.example.bcp.service;

import com.example.bcp.controller.web.dto.CambioMonedaResponse;
import com.example.bcp.controller.web.dto.TipoCambio;
import io.reactivex.Single;

public interface TipoCambioService {
    CambioMonedaResponse aplicarCambioYml(Double monto, String idMonedaOrigen, String idMonedaDestino);

    CambioMonedaResponse aplicarCambio(Double monto, String idMonedaOrigen, String idMonedaDestino);

    Single<TipoCambio> agregarTipoCambio(TipoCambio tipoCambio);

    Single<Double> obtenerTipoCambio(String idMonedaOrigen, String idMonedaDestino);
}
