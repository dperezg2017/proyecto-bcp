package com.example.bcp.repository;


import java.sql.SQLException;

public interface TipoCambioRepository  {
    Double obtenerTipoCambio(String idMonedaOrigen, String idMonedaDestino) throws SQLException;
}
