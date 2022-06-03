package com.generation.loja_games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.loja_games.model.Personagem;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long>{
	public List<Personagem> findAllByNomePersonagemContainingIgnoreCase(String nomePersonagem);
}
