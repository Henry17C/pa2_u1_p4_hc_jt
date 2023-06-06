package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.Cajero;
import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Impuesto;
import com.example.demo.banco.repository.modelo.Presidente;
import com.example.demo.banco.repository.modelo.Transferencia;
import com.example.demo.banco.service.CargaSistemaService;
import com.example.demo.banco.service.CuentaService;
import com.example.demo.banco.service.MontoDebitarService;
import com.example.demo.banco.service.TransferenciaService;
import com.example.demo.banco.service.TransferenciaServiceImpl;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U1P4HcJtApplication implements CommandLineRunner{

	@Autowired
	private Cajero cajero;
	
	@Autowired
	private Cajero cajero1;
	
	@Autowired
	private Presidente presidente;
	
	@Autowired
	private Presidente presidente2;
	
	@Autowired
	private CargaSistemaService cargaSistemaService;
	
	@Autowired
	private Impuesto impuesto;
	
	@Autowired
	private TransferenciaService transferenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4HcJtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	this.cajero.setApellido("Coyago");
	cajero.setNombre("Henry");
	cajero.setSalario(new BigDecimal(100));
		
	
	this.cajero1.setApellido("Teran");
	System.out.println(cajero);
	System.out.println(cajero1);
	System.out.println(cajero1.getApellido());
	
	this.presidente.setApellido("Porras");
	this.presidente.setNombre("Andrea");
	this.presidente.setCedula("12345");
	
	this.presidente2.setApellido("Taco");
	System.out.println(presidente);
	System.out.println(presidente2);
	
	System.out.println("***********************SEGUNDA PARTE");
	
	
	this.cargaSistemaService.cargar();
	
	System.out.println(this.impuesto);
	
	this.cargaSistemaService.cargar();
	Transferencia trans= new Transferencia();
	trans.setCuentaDestino(null);
	trans.setCuentaOrigen(null);
	trans.setFecha(LocalDateTime.now());
	trans.setMonto(new BigDecimal(100));
	trans.setNumero("12345");
	
	System.out.println(impuesto.getIva());
	
	
	
	
	
	
	}

}
