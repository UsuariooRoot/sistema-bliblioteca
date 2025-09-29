package com.colegio.servicio;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.entidad.Curso;

import com.colegio.repositorio.CursoRepository;


@Service
public class CursoServicioImpl implements CursoServicio{

	@Autowired
	private CursoRepository repository;
	

	@Override
	public List<Curso> listarTodos() {
		return repository.findAll();
}

	@Override
	public List<Curso> listarPorNombre(String filtro) {
		return repository.listaPorNombre(filtro);
	}

	@Override
	public Optional<Curso> buscaPorId(int id) {
		return repository.findById(id);
		
}
	@Override
	public List<Curso> listarPorSistemaEvaluacion(int idSistemaEvaluacion) {
		return repository.listaPorSistemaEvaluacion(idSistemaEvaluacion);
	}

	@Override
	public Curso insertaActualizaCurso(Curso obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public void eliminaCurso(int id) {
		repository.deleteById(id);
	}

	


}
