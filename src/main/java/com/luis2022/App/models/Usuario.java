package com.luis2022.App.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Nombres: campo obligatorio")
	private String nombres; 
	
	@NotEmpty(message= "Apellidos: Campo obligatorio")
	private String apellidos;
	
	@NotEmpty(message= "Correo: Campo obligatorio")
	private String correo; 


	@NotEmpty(message = "Cedula; Campo Obligatorio ")
	@Size(min = 10, max = 10, message = "La cédula debe tener 10 valores")
	private String cedula;

    @OneToOne(cascade=CascadeType.ALL )
	@Valid
	private Direccion direccion; 

	@NotEmpty()
	private String numero1; 
	
	@NotEmpty()
	private String numero2;

	public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNombres() {
	return nombres;
}

public void setNombres(String nombres) {
	this.nombres = nombres;
}

public String getApellidos() {
	return apellidos;
}

public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

public String getCorreo() {
	return correo;
}

public void setCorreo(String correo) {
	this.correo = correo;
}

public String getCedula() {
	return cedula;
}

public void setCedula(String cedula) {
	this.cedula = cedula;
}

public Direccion getDireccion() {
	return direccion;
}

public void setDireccion(Direccion direccion) {
	this.direccion = direccion;
}

public String getNumero1() {
	return numero1;
}

public void setNumero1(String numero1) {
	this.numero1 = numero1;
}

public String getNumero2() {
	return numero2;
}

public void setNumero2(String numero2) {
	this.numero2 = numero2;
}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


}
