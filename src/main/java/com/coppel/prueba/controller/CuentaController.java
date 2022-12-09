package com.coppel.prueba.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coppel.prueba.model.Cuenta;
import com.coppel.prueba.service.CuentaService;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

	@Autowired
	private CuentaService cuentaService;

	@GetMapping("/usuario/{idUsuario}")
	public ResponseEntity<?> findByIdUsuario(@PathVariable String idUsuario) {
		Iterable<Cuenta> cuentas = cuentaService.findByIdUsuario(idUsuario);
		return ResponseEntity.ok(cuentas);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> findAll() {
		Iterable<Cuenta> cuentas = cuentaService.findAll();
		return ResponseEntity.ok(cuentas);
	}

	@GetMapping("/{idCuenta}")
	public ResponseEntity<?> findById(@PathVariable String idCuenta) {
		Optional<Cuenta> oCuenta = cuentaService.findById(idCuenta);
		return ResponseEntity.ok(oCuenta);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Cuenta cuenta) {
		Cuenta resCuenta = cuentaService.save(cuenta);
		return ResponseEntity.status(HttpStatus.CREATED).body(resCuenta);
	}

	@PutMapping("/{idCuenta}")
	public ResponseEntity<?> update(@PathVariable String idCuenta, @RequestBody Cuenta cuenta) {
		Optional<Cuenta> oCuenta = cuentaService.findById(idCuenta);

		if (!oCuenta.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		oCuenta.get().setNombreDeLaCuenta(cuenta.getNombreDeLaCuenta());
		oCuenta.get().setBanco(cuenta.getBanco());
		oCuenta.get().setTipo(cuenta.getTipo());
		oCuenta.get().setMonto(cuenta.getMonto());
		oCuenta.get().setIdUsuario(cuenta.getIdUsuario());
		oCuenta.get().setIsActive(cuenta.getIsActive());
		
		Cuenta resCuenta = cuentaService.save(oCuenta.get());
		return ResponseEntity.status(HttpStatus.CREATED).body(resCuenta);
	}

	@DeleteMapping("/{idCuenta}")
	public ResponseEntity<?> deleteById(@PathVariable String idCuenta) {
		Optional<Cuenta> oCuenta = cuentaService.findById(idCuenta);

		if (!oCuenta.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Cuenta cuenta = oCuenta.get();
		cuenta.setIsActive(false);
		cuentaService.save(cuenta);

		return ResponseEntity.ok().build();
	}
	
	

}
