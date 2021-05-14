package edu.pe.idat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.pe.idat.model.Contacto;
import edu.pe.idat.model.Proforma;
import edu.pe.idat.service.ContactoService;

@Controller
@RequestMapping("/Contactanos")
public class ContactoController {

	@Autowired
	private ContactoService service;

	
	@GetMapping("/Contacto")
	public String Contacto(Model model,final HttpServletRequest request) {
		model.addAttribute("contactoForm",new Contacto());
		model.addAttribute("email", request.getSession().getAttribute("email"));
		model.addAttribute("visualizar", false);
		return "Contactanos/frmContacto";
	}

	@PostMapping("/Contacto")
	public String Contacto(@ModelAttribute("contactoForm") Contacto contactoForm, Model model,
			final HttpServletRequest request) {
		
		request.getSession().setAttribute("consulta", contactoForm);
		
		service.registrarConsulta2((Contacto)request.getSession().getAttribute("consulta"));
		
		model.addAttribute("visualizar", true);
		model.addAttribute("mensaje", "Enviado Correctamente");
		return "Contactanos/frmContacto";
	}
	
	@GetMapping("/ListaConsultas")
	public String ListaConsultas(Model model, final HttpServletRequest request) {;
		model.addAttribute("usuario",request.getSession().getAttribute("nombreUsuario"));
		model.addAttribute("lstconsulta",service.listarConsulta());		
		return "Contactanos/listaConsulta";
	}
	
}
