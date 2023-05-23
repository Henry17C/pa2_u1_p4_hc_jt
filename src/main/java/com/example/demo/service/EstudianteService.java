package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteService {
	
	
	public  void guardar (Estudiante estu);
	public  void actualizar (Estudiante estu);
	public  Estudiante buscarPorCedula (String cedula);//se buscar por el identificador
	public  void borrar (String cedula);//se elimina por un identificador
	public List<Estudiante> reporteDeTodos();


}
