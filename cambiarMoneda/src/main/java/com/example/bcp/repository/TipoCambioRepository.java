package com.example.bcp.repository;


import com.example.bcp.controller.web.dto.TipoCambio;
import com.example.bcp.controller.web.dto.TipoCambioRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoCambioRepository extends JpaRepository<TipoCambio, TipoCambioRequest> {
}
