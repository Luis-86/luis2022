package com.luis2022.App.repositories;

import org.springframework.data.repository.CrudRepository;

import com.luis2022.App.models.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long>{
	//Aqui metodos de consulta personalizados
	

}
