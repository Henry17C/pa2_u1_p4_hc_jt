package com.example.demo.banco.repository;

import com.example.demo.banco.repository.modelo.Trasferencia;

public interface TrasferrenciaRepo {

	public void insertar(Trasferencia transferencia);
	public void actualizar (Trasferencia transferencia);
	public void eliminar(String numero);
	public Trasferencia seleccionarNumero(String numero);
	
}
