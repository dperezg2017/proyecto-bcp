package com.example.bcp.repository;


import java.sql.SQLException;

public interface TipoCambioRepository  {
    Double obtenerTipoCambio(String monedaOrigen, String monedaDestino) throws SQLException;
}
