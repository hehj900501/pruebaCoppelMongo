package com.coppel.prueba.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Cuentas")
public class Cuenta {

	@Id
	private String id;
	
	private String nombreDeLaCuenta;
	
	private String banco;
	
	private String tipo;
	
	private String monto;
	
	private String idUsuario;
	
	private Boolean isActive;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreDeLaCuenta() {
		return nombreDeLaCuenta;
	}

	public void setNombreDeLaCuenta(String nombreDeLaCuenta) {
		this.nombreDeLaCuenta = nombreDeLaCuenta;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
