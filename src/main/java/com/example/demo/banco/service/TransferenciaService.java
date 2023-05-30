package com.example.demo.banco.service;

import java.math.BigDecimal;

import com.example.demo.banco.repository.modelo.Trasferencia;

public interface TransferenciaService {
	
	public void guardar(Trasferencia transferencia);
	public void actualizar (Trasferencia transferencia);
	public void borrar(String numero);
	public Trasferencia buscarNumero(String numero);

	public void realizar(String numCuentaOrigen, String numCuentaDestino, BigDecimal monto);
}
