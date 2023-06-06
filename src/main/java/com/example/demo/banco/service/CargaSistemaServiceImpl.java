package com.example.demo.banco.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.ImpuestoRepository;
import com.example.demo.banco.repository.modelo.Impuesto;



@Service
public class CargaSistemaServiceImpl implements CargaSistemaService {
@Autowired
private Impuesto impuesto;
	
	@Autowired
	private ImpuestoRepository impuestoRepository;
	
	@Override
	public void cargar() {
		// TODO Auto-generated method stub
		System.out.println("Inicia carga impuesto");
		BigDecimal valorIva= impuestoRepository.seleccionar("IVA");
		impuesto.setIva(valorIva);
		System.out.println("Fin carga impuesto");

	
	}

}
