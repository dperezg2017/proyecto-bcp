package com.example.bcp.repository.rowmapper;

import com.example.bcp.controller.web.dto.TipoCambio;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TipoCambioMapper implements RowMapper<TipoCambio> {

    @Override
    public TipoCambio mapRow(ResultSet rs, int i) throws SQLException {
        TipoCambio tipoCambio = new TipoCambio();
        tipoCambio.setTipo(rs.getDouble("TIPO"));
        return tipoCambio;
    }

}
