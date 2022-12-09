package com.coppel.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coppel.prueba.model.Cuenta;
import com.coppel.prueba.repository.ICuentaRepository;

@Service
public class CuentaService {

	@Autowired
	private ICuentaRepository iCuentaRepository;

	public List<Cuenta> findAll() {
		return iCuentaRepository.findAll();
	}

	public Optional<Cuenta> findById(String idCuenta) {
		return iCuentaRepository.findById(idCuenta);
	}

	public Cuenta save(Cuenta cuenta) {
		Cuenta resCuenta = iCuentaRepository.save(cuenta);
		return resCuenta;
	}

	public void deleteById(String idCuenta) {
		iCuentaRepository.deleteById(idCuenta);
	}

	public Iterable<Cuenta> findByIdUsuario(String idUsuario) {
		return iCuentaRepository.findByIdUsuario(idUsuario);
	}
}
