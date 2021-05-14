package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import edu.pe.idat.model.Proforma;
import edu.pe.idat.repository.ProformaRepository;

@Service
public class ProformaService {

	@Autowired
	private ProformaRepository repository;
	
	public List<Proforma> listarProforma(){
		return repository.findAll();
	}
	
	public void registrarProforma(Proforma p) {
		repository.save(p);
	}
	
	public List<Proforma> BuscarProforma(Integer id){
		return repository.BuscarProforma(id);
	}
	
}
