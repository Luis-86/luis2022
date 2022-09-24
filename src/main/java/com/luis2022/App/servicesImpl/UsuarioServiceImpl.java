package com.luis2022.App.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luis2022.App.models.Usuario;
import com.luis2022.App.repositories.IUsuarioRepository;
import com.luis2022.App.services.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	
	@Autowired 
	private IUsuarioRepository repository;

	@Override
	@Transactional
	public Usuario guardar(Usuario usuario) {
		return this.repository.save(usuario);
	}

	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listar() {
		return (List<Usuario>)this.repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario buscarPorId(Long id) {
		
		return this.repository.findById(id).orElse(null);
		
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		this.repository.deleteById(id);
		
	}

}
