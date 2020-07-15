package com.example.bcp.service;

import com.example.bcp.controller.web.dto.CambioMonedaResponse;
import com.example.bcp.controller.web.dto.TipoCambio;
import io.reactivex.Single;

public interface TipoCambioService {
    CambioMonedaResponse aplicarCambioYml(Double monto, Integer monedaOrigen, Integer monedaDestino);

    CambioMonedaResponse aplicarCambio(Double monto, Integer monedaOrigen, Integer monedaDestino);

    Single<TipoCambio> agregarTipoCambio(TipoCambio tipoCambio);

    Single<Double> obtenerTipoCambio(Integer monedaOrigen, Integer monedaDestino);
}
