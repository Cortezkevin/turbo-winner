package edu.pe.idat.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pe.idat.model.Proforma;
import edu.pe.idat.model.Proyecto;
import edu.pe.idat.service.ProformaService;
import edu.pe.idat.service.ProyectoService;

@Controller
@RequestMapping("/Proyectos")
public class ProyectoController {

	@Autowired
	private ProyectoService service;

	@Autowired
	private ProformaService proformaService;

	static List<String> lstUbicacion = Arrays.asList("San Isidro", "Barranco", "Miraflores");
	
	@GetMapping("/Proyecto")
	public String Proyecto(Model model) {
		model.addAttribute("lstubicaion",lstUbicacion);
		model.addAttribute("proyectoForm", new Proyecto());
		model.addAttribute("visualizar", false);
		return "Proyectos/frmProyecto";
	}
	
	@PostMapping("/Proyecto")
	public String Proyecto(@ModelAttribute("proyectoForm") Proyecto proyectoForm, Model model,
			final HttpServletRequest request) {
		model.addAttribute("lstubicaion",lstUbicacion);
		Double costo = 0.0;
		if(proyectoForm.getUbicacion().equals("San Isidro")){
			costo = 8671.39;}
		else if(proyectoForm.getUbicacion().equals("Barranco")){
			costo = 8400.20;}
		else if(proyectoForm.getUbicacion().equals("Miraflores")){
			costo = 7766.05;}
		Double metroscuadrados = proyectoForm.getArea();
		request.getSession().setAttribute("mont", metroscuadrados * costo);
		request.getSession().setAttribute("proyecto", proyectoForm);
		service.registrarProyecto((Proyecto) request.getSession().getAttribute("proyecto"));
		model.addAttribute("visualizar", true);
		model.addAttribute("mensaje", "Enviado Correctamente");
		return "Proyectos/frmProyecto";
	}

	@GetMapping("/ListaProyecto")
	public String ListaProyecto(Model model,final HttpServletRequest request) {
		model.addAttribute("usuario",request.getSession().getAttribute("nombreUsuario"));
		model.addAttribute("lstProyectos", service.listarProyecto());
		return "Proyectos/listadoProyectos";
	}

}
