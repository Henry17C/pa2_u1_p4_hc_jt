package com.example.demo.banco.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.repository.modelo.Cuenta;

@Repository
public class CuentaRepositoryImpl implements CuentaRepo{

	private static	List<Cuenta> baseDatos= new ArrayList<>();
	@Override
	public void insertar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		baseDatos.add(cuenta);
	}

	@Override
	public void actualizar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		this.eliminar(cuenta.getNumero());
		this.insertar(cuenta);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		Cuenta cuenta = this.seleccionarNumero(numero);
		baseDatos.remove(cuenta);
	}

	@Override
	public Cuenta seleccionarNumero(String numero) {
		Cuenta cuentaEncontrada = new Cuenta();
		
		for(Cuenta cuenta: baseDatos) {
			//siempre evaluar por el elemento que sabemos no va a ser nulo, para evitar errores
			//en compilacion
				 if(numero.equals(cuenta.getNumero())) {
					 cuentaEncontrada=cuenta;
				 }
		}
		
		return cuentaEncontrada;
	}

	
}
