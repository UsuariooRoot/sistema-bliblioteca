package com.colegio.servicio;

import java.util.List;
import java.util.Optional;

import com.colegio.entidad.Curso;

public interface CursoServicio {
	
	//public int registrarCurso( Curso e);
	public abstract Curso insertaActualizaCurso(Curso obj);
	public abstract void eliminaCurso(int id);
	public abstract List<Curso> listarTodos();
	public abstract List<Curso> listarPorNombre(String filtro);
	public abstract Optional<Curso> buscaPorId(int id);
	public abstract List<Curso> listarPorSistemaEvaluacion(int idSistemaEvaluacion);
	
	
}
