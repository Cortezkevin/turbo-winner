package edu.pe.idat.controller;

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
@RequestMapping("/Proformas")
public class ProformaController {

	@Autowired
	private ProyectoService proyectoService;

	@Autowired
	private ProformaService proformaService;

	@GetMapping("/Proforma")
	public String Proforma(Model model, final HttpServletRequest request) {
		model.addAttribute("proformaForm", new Proforma());
		model.addAttribute("monto",request.getSession().getAttribute("mont"));
		model.addAttribute("visualizar", false);
		List<Proyecto> lstproyectos = proyectoService.listarProyecto();
		model.addAttribute("proyectos",lstproyectos) ;
		
		return "Proformas/frmProforma";
	}

	@PostMapping("/Proforma")
	public String Proforma(@ModelAttribute("proformaForm") Proforma proformaForm, Model model,
			final HttpServletRequest request) {
		List<Proyecto> lstproyectos = proyectoService.listarProyecto();
		model.addAttribute("proyectos",lstproyectos) ;
		proformaForm.setMonto((Double)request.getSession().getAttribute("mont"));
		proformaService.registrarProforma(proformaForm);
		Double total = 0.0;
		total =  (Double)request.getSession().getAttribute("mont") - proformaForm.getImporte();
		model.addAttribute("visualizar", true);
		model.addAttribute("mensaje", "Enviado Correctamente, restaria : "+ total);
		return "Proformas/frmProforma";
	}
	
	@GetMapping("/ListaProformas")
	public String ListaProformas(Model model) {
		model.addAttribute("lstproforma",proformaService.listarProforma());		
		return "Proformas/listadoProforma";
	}

}
