package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U1P4HcJtApplication implements CommandLineRunner{

	
	@Autowired
	private EstudianteService estudianteService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4HcJtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//guardar estudiantes
		Estudiante miEstudiante= new Estudiante();
		miEstudiante.setApellido("Coyago");
		miEstudiante.setCedula("12345");
		miEstudiante.setNombre("Henry");
		miEstudiante.setFecha(LocalDateTime.of(1999, 3, 28, 10, 50));
		
		
		Estudiante estu2= new Estudiante();
		estu2.setApellido("Toscano");
		estu2.setCedula("1555");
		estu2.setNombre("Juan");
		estu2.setFecha(LocalDateTime.of(1999, 3, 28, 10, 50));
		
		
		//1. guardar
		estudianteService.guardar(estu2);
		estudianteService.guardar(miEstudiante);
		
		
		
		
		
		//5. reporte
		
		List <Estudiante> reporte=estudianteService.reporteDeTodos();
		System.out.println("Reporte");
		for(Estudiante estu : reporte) {
			System.out.println(estu);
		}
		
		//2 actualizar
		estu2.setApellido("Cayambe");
		 this.estudianteService.actualizar(estu2);
		
		
			//5. reporte
			
			List <Estudiante> reporte2=estudianteService.reporteDeTodos();
			System.out.println("Reporte");
			for(Estudiante estu : reporte2) {
				System.out.println(estu);
			}
		
			
			//4. eliminar
			this.estudianteService.borrar("1555");
			
			List <Estudiante> reporte3=estudianteService.reporteDeTodos();
			System.out.println("Reporte");
			for(Estudiante estu : reporte3) {
				System.out.println(estu);
			}
			
			
			System.out.println("Reporte");
			//buscar por cedula, busqueda de una cedula no existente
			Estudiante miEstu1=this.estudianteService.buscarPorCedula("12345");
			Estudiante miEstu2=this.estudianteService.buscarPorCedula("123456");
			
		System.out.println(miEstu1);
		System.out.println(miEstu2);
			
			
			
		
		
	}

}
