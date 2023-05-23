package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EstudianteRepo;
import com.example.demo.repository.modelo.Estudiante;
@Service
public class EstudianteServiceImpl  implements EstudianteService{
	//logica de negocio
	@Autowired
	private EstudianteRepo estudianteRepo;

	@Override
	public void guardar(Estudiante estu) {
		
		estudianteRepo.insertar(estu);
		
	}

	@Override
	public void actualizar(Estudiante estu) {
		estudianteRepo.actualizar(estu);
		
	}

	@Override
	public Estudiante buscarPorCedula(String cedula) {
		return estudianteRepo.seleccionar(cedula);
	}

	@Override
	public void borrar(String cedula) {
		estudianteRepo.eliminar(cedula);
		
	}

	@Override
	public List<Estudiante> reporteDeTodos() {
		return estudianteRepo.seleccionarTodos();
	}

}
