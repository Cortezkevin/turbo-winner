package edu.pe.idat.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.pe.idat.model.Usuario;
import edu.pe.idat.service.UsuarioService;

@Controller
public class HomeController {
	
	@Autowired
	private UsuarioService service;

	@GetMapping("/Home")
	public String Home(Model model) {
		model.addAttribute("usuarioForm", new Usuario());
		model.addAttribute("visualizar",false);
		return "login";
	}
	
	@PostMapping("/Home")
	public String Home(@ModelAttribute("usuarioForm") Usuario usuarioForm, Model model,final HttpServletRequest request) {
		if(usuarioForm.getNombreUsuario().equals("")|| usuarioForm.getPassword().equals("")){
			model.addAttribute("visualizar",true);
			model.addAttribute("mensaje","Nombre de Usuario o Contraseña vacio");
			return "login";
			}
		Usuario obj = (Usuario)service.BuscarUsuario(usuarioForm.getNombreUsuario());
		request.getSession().setAttribute("email", obj.getEmail());
		if((usuarioForm.getNombreUsuario().equals(obj.getNombreUsuario())) &&
			(usuarioForm.getPassword().equals(obj.getPassword()))) {
			request.getSession().setAttribute("nombreUsuario", usuarioForm.getNombreUsuario());
			return "menu";			
		}else {
			model.addAttribute("visualizar",true);
			model.addAttribute("mensaje","Nombre de Usuario o Contraseña incorrectos");
			return "login";
		}
		
		
	}
	
	@GetMapping("/RegistrarUsuario")
	public String RegistrarUsuario(Model model) {
		model.addAttribute("usuarioForm", new Usuario());
		model.addAttribute("visualizar",false);
		return "registroUsuario";
	}
	
	@PostMapping("/RegistrarUsuario")
	public String RegistrarUsuario(@ModelAttribute("usuarioForm") Usuario usuarioForm, Model model) {
		service.RegistrarUsuario(usuarioForm);
		model.addAttribute("visualizar",true);
		model.addAttribute("mensaje","usuario registrado correctamente");
		return "redirect:/Home";
	}
	
}
