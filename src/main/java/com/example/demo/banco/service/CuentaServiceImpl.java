package com.example.demo.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.CuentaRepo;
import com.example.demo.banco.repository.modelo.Cuenta;

@Service
public class CuentaServiceImpl implements CuentaService {

	@Autowired
	private CuentaRepo cuentaRepo;
	
	
	@Override
	public void guardar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		this.cuentaRepo.insertar(cuenta);
	}

	@Override
	public void actualizar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		
		
		this.cuentaRepo.actualizar(cuenta);
		
	}

	@Override
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.cuentaRepo.eliminar(numero);
	}

	@Override
	public Cuenta buscarNumero(String numero) {
		// TODO Auto-generated method stub
		return this.cuentaRepo.seleccionarNumero(numero);
	}

	
	
	
	
	
}
