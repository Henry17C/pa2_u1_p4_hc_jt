package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U1P4HcJtApplication implements CommandLineRunner{

	@Autowired
	private Profesor profe2;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4HcJtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		System.out.println("Mi primer proyecto");
		/* Spring Framework, permite la construccion
		 *  y desarrollo de aplcaciones empresariales 
		 *  basadas en Spring
		 */
		
		
		
		Profesor profesor= new Profesor();
		profesor.setApellido("Coyago");
		profesor.setCedula("17555");
		profesor.setFechaNacimiento(LocalDateTime.now());;
		profesor.setNombre("Henry");
		
		
		System.out.println(profesor);
		profesor.setApellido("Velez");
		System.out.println(profesor.getApellido());
		
		System.out.println(profe2);
		profe2.setApellido("toscano");
		profe2.setApellido("");
		System.out.println(profe2.getApellido());
		
		Profesor profe3;
		
		profe3 = profesor;
		System.out.println(profe3);
		profesor.setApellido("V");
		System.out.println(profe3);
		
		MatriculaCalculo mat =  new MatriculaCalculo();
		mat.realizarMatricula("1");
	}

}
