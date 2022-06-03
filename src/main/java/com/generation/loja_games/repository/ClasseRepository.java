package com.generation.loja_games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.loja_games.model.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long>{
	public List<Classe> findAllByTipoClasseContainingIgnoreCase(String tipoClasse);
}
