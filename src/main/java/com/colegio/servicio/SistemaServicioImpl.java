package com.colegio.servicio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.entidad.SistemaEvalucion;
import com.colegio.repositorio.SistemaEvaluacionRepository;

@Service
public class SistemaServicioImpl implements SistemaServicio{

	@Autowired
	private SistemaEvaluacionRepository repository;

	@Override
	public List<SistemaEvalucion> listarTodos() {
		return repository.findAll();
	}
	
	
}
