package com.example.bcp.controller.web;

import com.example.bcp.controller.web.dto.CambioMonedaResponse;
import com.example.bcp.controller.web.dto.TipoCambio;
import com.example.bcp.service.TipoCambioService;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/tipocambio")
public class TipoCambioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TipoCambioController.class);
    TipoCambioService tipoCambioService;

    public TipoCambioController(TipoCambioService tipoCambioService) {
        this.tipoCambioService = tipoCambioService;
    }

    @PostMapping(value = "/cambiarMoneda")
    public CambioMonedaResponse cambiarMoneda(@RequestParam("monto") Double monto, @RequestParam("monedaOrigen") Integer monedaOrigen, @RequestParam("monedaDestino") Integer monedaDestino) {

        CambioMonedaResponse CambioMonedaResponse = tipoCambioService.aplicarCambio(monto, monedaOrigen, monedaDestino);
        LOGGER.info("se aplico tipo de cambio: {} ", CambioMonedaResponse.toString());
        return CambioMonedaResponse;
    }

    @PostMapping
    public Single<ResponseEntity<TipoCambio>> agregarTipoCambio(@RequestBody TipoCambio tipoCambio) {
        return tipoCambioService.agregarTipoCambio(tipoCambio)
                .subscribeOn(Schedulers.io())
                .map(s -> ResponseEntity
                        .created(URI.create("/tipocambio/" + s))
                        .body(tipoCambio));
    }




}
