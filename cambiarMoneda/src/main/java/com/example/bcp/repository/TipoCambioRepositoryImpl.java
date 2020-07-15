package com.example.bcp.repository;


import com.example.bcp.controller.web.dto.TipoCambio;
import com.example.bcp.repository.rowmapper.TipoCambioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TipoCambioRepositoryImpl implements TipoCambioRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(TipoCambioRepositoryImpl.class);
    private final JdbcTemplate jdbcTemplate;
    private DataSource datasource;
    private final TipoCambioMapper tipoCambioMapper;

    public TipoCambioRepositoryImpl(JdbcTemplate jdbcTemplate, TipoCambioMapper tipoCambioMapper,DataSource datasource) {
        this.jdbcTemplate = jdbcTemplate;
        this.tipoCambioMapper = tipoCambioMapper;
        this.datasource = datasource;
    }
//    @Override
//    public Double obtenerTipoCambio(Integer monedaOrigen, Integer monedaDestino) {
//        try {
//            List< TipoCambio > list = new ArrayList<>();
//            String sql ="SELECT TIPO FROM TIPOCAMBIO WHERE ID_MONEDA_DESTINO=? AND ID_MONEDA_ORIGEN=?";
//            Connection conn = datasource.getConnection() ;
//            PreparedStatement pstmt = conn.prepareStatement( sql ) ;
//            pstmt.setDouble( 1 , monedaDestino );
//            pstmt.setDouble( 2 , monedaOrigen );
//            try ( ResultSet rs = pstmt.executeQuery() ; ) {
//                while ( rs.next() ) {
//                    TipoCambio pkey = rs.getObject( "TIPO" , TipoCambio.class );
//                    list.add( pkey );
//                }
//            }
//            return null;
//        }catch (Exception e){
//            LOGGER.error("error: ",e);
//            return null;
//        }
//    }

//    @Override
//    public Double obtenerTipoCambio(Integer monedaOrigen, Integer monedaDestino) {
//        try {
//            Session sesion=getSession();
//            String sql ="SELECT TIPO FROM TIPOCAMBIO WHERE ID_MONEDA_DESTINO=:monedaDestino AND ID_MONEDA_ORIGEN=:monedaOrigen";
//            Query q = getSession().createSQLQuery(sql);
//        }catch (Exception e){
//            LOGGER.error("error: ",e);
//            return null;
//        }
//    }

    @Override
    public Double obtenerTipoCambio(Integer monedaOrigen, Integer monedaDestino) {
        List<TipoCambio> tipoCambio = null;
        try {
            String sql = "SELECT TIPO FROM TIPOCAMBIO WHERE ID_MONEDA_DESTINO=? AND ID_MONEDA_ORIGEN=? ";
            tipoCambio = jdbcTemplate.query(sql, new Object[]{monedaDestino,monedaOrigen}, new TipoCambioMapper());
            return (tipoCambio.size()>0)?tipoCambio.get(0).getTipo():null;
        }catch (Exception e){
            LOGGER.error("Error al obtener el tipo de cambio: ",e);
            return null;
        }
    }
}
