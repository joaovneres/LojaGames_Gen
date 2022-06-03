package com.generation.loja_games.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_personagem")
public class Personagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersonagem;
	
	@NotBlank
	@Size(min = 3, max=30)
	private String nomePersonagem;
	
	@NotNull
	private Integer nivelPersonagem;
	
	@NotBlank
	@Size(min=3, max=15)
	private String raridadePersonagem;
	
	@NotNull
	private Integer ataquePersonagem;
	
	@NotNull
	private Integer defesaPersonagem;
	
	@ManyToOne
	@JsonIgnoreProperties("oPersonagem")
	private Classe oClasse;

	public Long getIdPersonagem() {
		return idPersonagem;
	}

	public void setIdPersonagem(Long idPersonagem) {
		this.idPersonagem = idPersonagem;
	}

	public String getNomePersonagem() {
		return nomePersonagem;
	}

	public void setNomePersonagem(String nomePersonagem) {
		this.nomePersonagem = nomePersonagem;
	}

	public Integer getNivelPersonagem() {
		return nivelPersonagem;
	}

	public void setNivelPersonagem(Integer nivelPersonagem) {
		this.nivelPersonagem = nivelPersonagem;
	}

	public String getRaridadePersonagem() {
		return raridadePersonagem;
	}

	public void setRaridadePersonagem(String raridadePersonagem) {
		this.raridadePersonagem = raridadePersonagem;
	}

	public Integer getAtaquePersonagem() {
		return ataquePersonagem;
	}

	public void setAtaquePersonagem(Integer ataquePersonagem) {
		this.ataquePersonagem = ataquePersonagem;
	}

	public Integer getDefesaPersonagem() {
		return defesaPersonagem;
	}

	public void setDefesaPersonagem(Integer defesaPersonagem) {
		this.defesaPersonagem = defesaPersonagem;
	}

	public Classe getoClasse() {
		return oClasse;
	}

	public void setoClasse(Classe oClasse) {
		this.oClasse = oClasse;
	}
	
}
