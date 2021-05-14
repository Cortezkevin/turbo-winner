package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Usuario;
import edu.pe.idat.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public void RegistrarUsuario(Usuario u) {
		repository.save(u);
	}
	public Usuario BuscarUsuario(String nombre){
		return repository.findByNombreUsuario(nombre);
	}
}
