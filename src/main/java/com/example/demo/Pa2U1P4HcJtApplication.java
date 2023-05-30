package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.service.CuentaService;
import com.example.demo.banco.service.TransferenciaService;
import com.example.demo.banco.service.TransferenciaServiceImpl;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U1P4HcJtApplication implements CommandLineRunner{

	
	@Autowired
	private CuentaService cuentaService;
	
	@Autowired
	private TransferenciaService transferenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4HcJtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cuenta cuenta1 = new Cuenta();
		Cuenta cuenta2 = new Cuenta();
		
		//c1
		cuenta1.setCedulaPropietario("1234");
		cuenta1.setFechaApertura(LocalDateTime.now());
		cuenta1.setNumero("5678");
		cuenta1.setSaldo(new BigDecimal(200));
		cuenta1.setTipo("A");
		this.cuentaService.guardar(cuenta1);

		
		//c2
		cuenta2.setCedulaPropietario("0987");
		cuenta2.setFechaApertura(LocalDateTime.now());
		cuenta2.setNumero("7890");
		cuenta2.setSaldo(new BigDecimal(100));
		cuenta2.setTipo("A");
		this.cuentaService.guardar(cuenta2);	

		
		//insertar
			
		
		this.transferenciaService.realizar("5678", "7890", new BigDecimal(10));

		System.out.println("saldo origen"+	this.cuentaService.buscarNumero("5678").getSaldo());
		System.out.println("saldo destino"+	this.cuentaService.buscarNumero("7890").getSaldo());

		
		
		
	}

}
