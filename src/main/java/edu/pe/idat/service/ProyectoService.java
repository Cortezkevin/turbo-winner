package edu.pe.idat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Proforma;
import edu.pe.idat.model.Proyecto;
import edu.pe.idat.repository.ProyectoRepository;

@Service
public class ProyectoService {

	@Autowired
	private ProyectoRepository repository;
	
	
	public List<Proyecto> listarProyecto(){
		return repository.findAll();
	}
	
	public void registrarProyecto(Proyecto p) {
		repository.save(p);
	}
	
	public List<Proyecto> BuscarProyecto(Integer id){
		return repository.BuscarProyecto(id);
	}

}
