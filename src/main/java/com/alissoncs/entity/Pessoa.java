package com.alissoncs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotBlank
	private String nome;

	@ManyToOne(targetEntity = Genero.class)
	private Genero genero;
	
	@ManyToOne(targetEntity = Etnia.class)
	private Etnia etnia;
	
	@ManyToOne(targetEntity = Religiao.class)
	private Religiao religiao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Etnia getEtnia() {
		return etnia;
	}
	public void setEtnia(Etnia etnia) {
		this.etnia = etnia;
	}
	public Religiao getReligiao() {
		return religiao;
	}
	public void setReligiao(Religiao religiao) {
		this.religiao = religiao;
	}
	
}
