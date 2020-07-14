package com.example.bcp.service;

import com.example.bcp.controller.web.dto.CambioMonedaResponse;
import com.example.bcp.controller.web.dto.TipoCambio;
import com.example.bcp.controller.web.dto.TipoCambioRequest;
import io.reactivex.Single;

public interface TipoCambioService {
    CambioMonedaResponse aplicarCambio(Double monto, Integer monedaOrigen, Integer monedaDestino);

    Single<TipoCambio> agregarTipoCambio(TipoCambio tipoCambio);
}
