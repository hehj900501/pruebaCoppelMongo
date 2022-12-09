package com.coppel.prueba.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coppel.prueba.model.Cuenta;

@Repository
public interface ICuentaRepository extends MongoRepository<Cuenta, String>{
	
	@Transactional(readOnly = true)
	Iterable<Cuenta> findByIdUsuario(String idUsuario);

}
