package com.douglas.freire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.douglas.freire.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{
	Contato findByid(Long id);

}
