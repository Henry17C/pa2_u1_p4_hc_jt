package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.banco.repository.modelo.Transferencia;

public interface TransferenciaService {
	
	public void guardar(Transferencia transferencia);
	public void actualizar (Transferencia transferencia);
	public void borrar(String numero);
	public Transferencia buscarNumero(String numero);

	public void realizar(String numCuentaOrigen, String numCuentaDestino, BigDecimal monto);
	public List<Transferencia> estadoCuenta();

}
