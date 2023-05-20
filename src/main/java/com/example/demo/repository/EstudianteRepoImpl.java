package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;
@Repository

public class EstudianteRepoImpl implements EstudianteRepo {

	
private static	List<Estudiante> baseDatos= new ArrayList<>();
	@Override
	public void insertar(Estudiante estu) {
		
		baseDatos.add(estu);
		
	}

	@Override
	public void actualizar(Estudiante estu) {
		
	}

	@Override
	public Estudiante seleccionar(String cedula) {
		return null;
	}

	@Override
	public void eliminar(String cedula) {
		
	}

}
