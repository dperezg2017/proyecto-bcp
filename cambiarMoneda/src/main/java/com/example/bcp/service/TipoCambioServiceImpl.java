package com.example.bcp.service;

import com.example.bcp.config.TipoCambioProperties;
import com.example.bcp.controller.web.dto.CambioMonedaResponse;
import com.example.bcp.controller.web.dto.TipoCambio;
import com.example.bcp.controller.web.dto.TipoCambioRequest;
import com.example.bcp.repository.TipoCambioRepository;
import io.reactivex.Single;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

    private TipoCambioRepository tipoCambioRepository;

    private final TipoCambioProperties tipoCambioProperties;

    public TipoCambioServiceImpl(TipoCambioProperties tipoCambioProperties,TipoCambioRepository tipoCambioRepository) {
        this.tipoCambioProperties = tipoCambioProperties;
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
            TipoCambio tipoCambioSave= tipoCambioRepository.save(tipoCambio);
            singleSubscriber.onSuccess(tipoCambioSave);
        });
    }

}
