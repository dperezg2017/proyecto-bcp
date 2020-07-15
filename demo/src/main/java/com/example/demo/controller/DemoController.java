package com.example.demo.controller;

import com.example.demo.controller.dto.CambioMonedaResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;
import rx.functions.Action1;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @PostMapping(value = "/cambiarMonedaDemo")
    public CambioMonedaResponse cambiarMonedaDemo(@RequestParam("monto") Double monto, @RequestParam("monedaOrigen") String monedaOrigen, @RequestParam("monedaDestino") String monedaDestino) {

        CambioMonedaResponse ca = new CambioMonedaResponse();

        Double tipo= 10.02;
        Observable<Double> cambiarMoneda = Observable.just(tipo);

        cambiarMoneda.subscribe(new Action1<Double>() {
            @Override
            public void call(Double tipo) {
                ca.setTipoCambio(tipo);
            }
        });

        ca.getTipoCambio();



        return ca;
    }
}
