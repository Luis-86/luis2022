package com.luis2022.App.services;

import java.util.List;

import com.luis2022.App.models.Usuario;

public interface IUsuarioService {
	
	public Usuario guardar(Usuario usuario);
	
	public List<Usuario> listar();
	
	public Usuario buscarPorId(Long id);
	
	public void eliminar(Long id);	

}
