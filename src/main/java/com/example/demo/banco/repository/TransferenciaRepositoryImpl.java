package com.example.demo.banco.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.repository.modelo.Trasferencia;


@Repository
public class TransferenciaRepositoryImpl implements TrasferrenciaRepo{

	private static	List<Trasferencia> baseDatos= new ArrayList<>();
	@Override
	public void insertar(Trasferencia transferencia) {
		// TODO Auto-generated method stub
		baseDatos.add(transferencia);
	}

	@Override
	public void actualizar(Trasferencia transferencia) {
		// TODO Auto-generated method stub
		this.eliminar(transferencia.getNumero());
		this.insertar(transferencia);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		Trasferencia trans = this.seleccionarNumero(numero);
		baseDatos.remove(trans);
	}

	@Override
	public Trasferencia seleccionarNumero(String numero) {
    Trasferencia transEncontrado= new Trasferencia();
		
		for(Trasferencia trans: baseDatos) {
			//siempre evaluar por el elemento que sabemos no va a ser nulo, para evitar errores
			//en compilacion
				 if(numero.equals(trans.getNumero())) {
					 transEncontrado=trans;
				 }
		}
		
		return transEncontrado;
	}
	

}
