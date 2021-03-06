package br.com.docket.cartorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.docket.cartorio.entitys.model.entitys.Cartorio;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Long>{

	
}
