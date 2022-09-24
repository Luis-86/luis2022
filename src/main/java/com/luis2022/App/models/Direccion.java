package com.luis2022.App.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "direcciones")
public class Direccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Calle Principal: Campo Obligatorio")
    private String calle_principal;

    @NotEmpty(message = "Calle Secundaria: Campo Obligatorio")
    private String calle_secundaria;

    private String referencia;

    @Override
    public String toString() {
        return this.calle_principal + "/" + this.calle_secundaria + "/" + this.referencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle_principal() {
        return calle_principal;
    }

    public void setCalle_principal(String calle_principal) {
        this.calle_principal = calle_principal;
    }

    public String getCalle_secundaria() {
        return calle_secundaria;
    }

    public void setCalle_secundaria(String calle_secundaria) {
        this.calle_secundaria = calle_secundaria;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
