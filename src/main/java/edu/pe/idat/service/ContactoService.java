package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.pe.idat.model.Contacto;
import edu.pe.idat.repository.ContactoRepository;

@Service
public class ContactoService {

	@Autowired
	private ContactoRepository repository;

	public List<Contacto> listarConsulta() {
		return repository.findAll();
	}

	public void registrarConsulta(Contacto c) {
		if (c.getIdConsulta() == null) {
			repository.registrarConsulta(c.getNombre(), c.getEmail(), c.getAsunto(), c.getTelefono(), c.getMensaje());
		} else {
			repository.actualizarConsulta(c.getIdConsulta(), c.getNombre(), c.getEmail(), c.getAsunto(), c.getTelefono(), c.getMensaje());
		}
	}
	public void registrarConsulta2(Contacto b) {
		repository.save(b);
	}

	public void eliminarCurso(Contacto c) {
		repository.eliminarConsulta(c.getIdConsulta());
	}
}
