package com.example.bcp.repository;


import java.sql.SQLException;

public interface TipoCambioRepository  {
    Double obtenerTipoCambio(Integer monedaOrigen, Integer monedaDestino) throws SQLException;
}
