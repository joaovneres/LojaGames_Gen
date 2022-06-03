package com.generation.loja_games.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class Classe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClasse;
	
	@NotBlank
	@Size(min=4, max=30)
	private String tipoClasse;
	
	@NotBlank
	@Size(min=4, max =30)
	private String tipoAtaqueClasse;
	
	@NotBlank
	@Size(min=4, max=30)
	private String distanciaAtaqueClasse;
	
	@OneToMany(mappedBy = "oClasse", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("oClasse")
	private List<Personagem> oPersonagem;

	public Long getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(Long idClasse) {
		this.idClasse = idClasse;
	}

	public String getTipoClasse() {
		return tipoClasse;
	}

	public void setTipoClasse(String tipoClasse) {
		this.tipoClasse = tipoClasse;
	}

	public String getTipoAtaqueClasse() {
		return tipoAtaqueClasse;
	}

	public void setTipoAtaqueClasse(String tipoAtaqueClasse) {
		this.tipoAtaqueClasse = tipoAtaqueClasse;
	}

	public String getDistanciaAtaqueClasse() {
		return distanciaAtaqueClasse;
	}

	public void setDistanciaAtaqueClasse(String distanciaAtaqueClasse) {
		this.distanciaAtaqueClasse = distanciaAtaqueClasse;
	}

	public List<Personagem> getoPersonagem() {
		return oPersonagem;
	}

	public void setoPersonagem(List<Personagem> oPersonagem) {
		this.oPersonagem = oPersonagem;
	}
	
	
}
