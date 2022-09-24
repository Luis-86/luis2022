package com.luis2022.App.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.luis2022.App.models.Usuario;
import com.luis2022.App.servicesImpl.UsuarioServiceImpl;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl service;

	// -------------Inicio Navegacion----------------
	@RequestMapping(value = "/form")
	public String ir_form(Map<String, Object> model) {
		Usuario usuario = new Usuario();
		model.put("titulo", "Formulario de Usuario");
		model.put("usuario", usuario);
		return "form";
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Map<String, Object> model) {
		List<Usuario> usuarios = this.service.listar();
		/*
		 * for(int i = 0; i<usuarios.size(); i++{
		 * System.out.println(usuarios.get(i).getApellidos()+""+usuarios.get(i).
		 * getNombres());
		 * }
		 */
		for (Usuario us : usuarios) {
			System.out.println(us.getCorreo() + " " + us.getNombres());
		}
		model.put("titulo", "lista de Usuarios");
		model.put("usuarios", usuarios);
		return "listar";
	}

	@RequestMapping(value = "/perfil")
	public String ir_perfil(Map<String, Object> model) {
		Usuario usuario = new Usuario();
		model.put("titulo", "Perfil de Usuario");
		model.put("usuario", usuario);
		return "form";
	}

	@RequestMapping(value = "/contactanos")
	public String ir_contactanos(Map<String, Object> model) {
		Usuario usuario = new Usuario();
		model.put("titulo", "Hola Contactanos");
		model.put("usuario", usuario);
		return "form";
	}

	@RequestMapping(value = "/calculadora")
	public String ir_calculadora(Map<String, Object> model) {
		Usuario usuario = new Usuario();
		model.put("titulo", "Calculadora Basica");
		model.put("usuario", usuario);
		return "calculadora";
	}


	// -------------Fin Navegacion---------------------
	// **************** */ METODOS DEL CRUD*******************

	@RequestMapping(value="/form", method = RequestMethod.POST)

	public String guardar_o_editar(@Valid Usuario usuario, 
	BindingResult result, 
	Model model, 
	SessionStatus status,
	RedirectAttributes flash){
		if (result.hasErrors()) {
			model.addAttribute("titulo","Formulario de Usuario");
			model.addAttribute("error","Revise el formulario");
			return "form";
		}
		String mensaje = "Usuario creado con exito";
		this.service.guardar(usuario);
		status.setComplete();
		flash.addFlashAttribute("success", mensaje);
		return "redirect:listar";
	}

	@RequestMapping(value = "/form/{id}")
	public String editar (@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash){
		Usuario us = null;
	us = this.service.buscarPorId(id);
	model.put("usuario", us);
	model.put("titulo", "Edicion de Usuario");
	return"form";

	}


		

    
	
	//******************FIN DEL METODO DEL CRUD***************/
	
	}
