package com.colegio.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.colegio.entidad.Curso;

import com.colegio.entidad.SistemaEvalucion;
import com.colegio.servicio.CursoServicio;
import com.colegio.servicio.SistemaServicio;

@Controller
public class CursoController {

	
	@Autowired
	private CursoServicio cursoService;
	
	@Autowired
	private SistemaServicio  sistemaevaluacionService;
 
	@RequestMapping("/vercrudCurso")
	public String verCrud() {
		return "crudCurso";
	}
	@RequestMapping("/cargasistemaevaluacion")
	@ResponseBody
	public List<SistemaEvalucion> listasistemaevaluacion() {
		return sistemaevaluacionService.listarTodos();
	}
	@RequestMapping("/consultaCrudCurso")
	public String lista(String filtro, HttpSession session) {
		List<Curso> lista =  cursoService.listarPorNombre(filtro+"%");
		session.setAttribute("cursos", lista);
		return "crudCurso";
	}
	@RequestMapping("/registraActualizaCrudCurso")
	public String registraActualiza(Curso obj, HttpSession session) {	
		try {
			Curso sal = cursoService.insertaActualizaCurso(obj);
			if(sal == null) {
				session.setAttribute("MENSAJE", "Existe ERROR");
			}else {
				session.setAttribute("MENSAJE", "Se registrÃ³ o actualizÃ³ correctamente");
			}
		} catch (Exception e) {
			session.setAttribute("MENSAJE", "Existe ERROR");
			e.printStackTrace();
		}
		return "redirect:salida";
	}
	@RequestMapping("/eliminaCrudCurso")
	public String elimina(int id, HttpSession session) {
		
		try {
			Optional<Curso> obj = cursoService.buscaPorId(id);
			if(obj.isPresent()) {
				cursoService.eliminaCurso(id);
				session.setAttribute("MENSAJE", "Se eliminÃ³ correctamente");
			}else {
				session.setAttribute("MENSAJE", "No existe el ID");	
			}	
		} catch (Exception e) {
			session.setAttribute("MENSAJE", "Existe ERROR");
			e.printStackTrace();
		}
		return "redirect:salida";
	}
	@RequestMapping("/salida")
	public String listarTodos(HttpSession session) {
		List<Curso> data = cursoService.listarTodos();
		session.setAttribute("cursos", data);
		return "crudCurso";
	}
	
	@RequestMapping("/listaTotalSistemas")
	@ResponseBody
	public List<SistemaEvalucion> lista(){
		return sistemaevaluacionService.listarTodos();
	}
	
	@RequestMapping("/consultarCursos")
	@ResponseBody
	public List<Curso> consulta(int parametro){
		List<Curso> lista = null;
		if(parametro == 0) {
			lista = new ArrayList<>();
		}else if(parametro == -1) {
			lista = cursoService.listarTodos();
		} else {
			lista = cursoService.listarPorSistemaEvaluacion(parametro);
		}
		return lista;
	}
	
	
	
}
