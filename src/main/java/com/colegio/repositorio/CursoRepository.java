package com.colegio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.colegio.entidad.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

	@Query( "select p from Curso p where p.nombre like :param")
	public abstract List<Curso>  listaPorNombre(@Param("param") String filtro);
	
	@Query("Select x from Curso x where x.sistemaevaluacion.idSistemaEvaluacion = :param")
	public abstract List<Curso> listaPorSistemaEvaluacion(@Param(value = "param")int idSistemaEvaluacion);
	
}
