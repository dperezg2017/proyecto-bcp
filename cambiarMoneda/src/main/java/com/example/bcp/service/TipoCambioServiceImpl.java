package com.example.bcp.service;

import com.example.bcp.config.TipoCambioProperties;
import com.example.bcp.controller.web.dto.CambioMonedaResponse;
import com.example.bcp.controller.web.dto.TipoCambio;
import com.example.bcp.repository.TipoCambioCrudRepository;
import com.example.bcp.repository.TipoCambioRepository;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TipoCambioServiceImpl.class);
    private TipoCambioCrudRepository tipoCambioCrudRepository;
    private TipoCambioRepository tipoCambioRepository;

    private final TipoCambioProperties tipoCambioProperties;

    public TipoCambioServiceImpl(TipoCambioProperties tipoCambioProperties, TipoCambioCrudRepository tipoCambioCrudRepository,TipoCambioRepository tipoCambioRepository) {
        this.tipoCambioProperties = tipoCambioProperties;
        this.tipoCambioCrudRepository = tipoCambioCrudRepository;
        this.tipoCambioRepository = tipoCambioRepository;
    }

    @Override
    public CambioMonedaResponse aplicarCambio(Double monto, Integer monedaOrigen, Integer monedaDestino) {




        CambioMonedaResponse CambioMonedaResponse = new CambioMonedaResponse();
        Double tipoCambio=0.00;

        // 1: sol  2:dolar  3:peso mexicano
        if(monedaOrigen==1 && monedaDestino==2){
            tipoCambio=tipoCambioProperties.getSol().getSolADolarUsa();
        }else if(monedaOrigen==1 && monedaDestino==3){
            tipoCambio=tipoCambioProperties.getSol().getSolAPesoMexicano();

        }else if(monedaOrigen==2 && monedaDestino==1){
            tipoCambio=tipoCambioProperties.getDolarUsa().getDolarUsaASol();
        }else if(monedaOrigen==2 && monedaDestino==3){
            tipoCambio=tipoCambioProperties.getSol().getSolAPesoMexicano();

        }else if(monedaOrigen==3 && monedaDestino==1){
            tipoCambio=tipoCambioProperties.getPesoMexicano().getPesosMexicanoASol();
        }else if(monedaOrigen==3 && monedaDestino==2){
            tipoCambio=tipoCambioProperties.getPesoMexicano().getPesosMexicanoADolarUsa();
        }

        CambioMonedaResponse.setMonto(monto);
        CambioMonedaResponse.setMontoTipoCambio(monto*tipoCambio);
        CambioMonedaResponse.setMonedaOrigen(monedaOrigen);
        CambioMonedaResponse.setMonedaDestino(monedaDestino);
        CambioMonedaResponse.setTipoCambio(tipoCambio);

        return CambioMonedaResponse;
    }


    @Override
    public Single<TipoCambio> agregarTipoCambio(TipoCambio tipoCambio) {
        return Single.create(singleSubscriber -> {
            TipoCambio tipoCambioSave= tipoCambioCrudRepository.save(tipoCambio);
            singleSubscriber.onSuccess(tipoCambioSave);
        });
    }

    @Override
    public Single<Double> obtenerTipoCambio(Integer monedaOrigen, Integer monedaDestino) {
        return Single.create(singleSubscriber -> {
           Double tipoCambio=tipoCambioRepository.obtenerTipoCambio(monedaOrigen,monedaDestino);
           singleSubscriber.onSuccess(tipoCambio);
           LOGGER.info("tipoCambio: {}",tipoCambio);
        });
    }

}
