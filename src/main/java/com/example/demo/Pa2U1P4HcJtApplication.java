package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.service.CuentaService;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U1P4HcJtApplication implements CommandLineRunner{

	
	@Autowired
	private CuentaService cuentaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4HcJtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cuenta cuenta1 = new Cuenta();
		Cuenta cuenta2 = new Cuenta();
		
		cuenta1.setCedulaPropietario(null);
		cuenta1.setNumero(null);
		cuenta1.setSaldo(null);
		cuenta1.setTipo(null);
			
			
		
		
	}

}
