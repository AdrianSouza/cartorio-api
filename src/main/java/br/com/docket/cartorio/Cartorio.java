package br.com.docket.cartorio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cartorio {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NOME")	
	private String nome;
}
