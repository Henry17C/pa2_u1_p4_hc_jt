package com.example.demo.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.TrasferrenciaRepo;
import com.example.demo.banco.repository.modelo.Trasferencia;

@Service
public class TransferenciaServiceImpl implements TransferenciaService{

	
	@Autowired
	private TrasferrenciaRepo repo;
	@Override
	public void guardar(Trasferencia transferencia) {
		// TODO Auto-generated method stub
		this.repo.insertar(transferencia);
	}

	@Override
	public void actualizar(Trasferencia transferencia) {
		// TODO Auto-generated method stub
		this.repo.actualizar(transferencia);
	}

	@Override
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.repo.eliminar(numero);
	}

	@Override
	public Trasferencia buscarNumero(String numero) {
		// TODO Auto-generated method stub
		return this.repo.seleccionarNumero(numero);
	}

}
