package com.generation.loja_games.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.loja_games.model.Classe;
import com.generation.loja_games.repository.ClasseRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/classes")
public class ClasseController {

	@Autowired
	private ClasseRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Classe>> lsitar(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{idClasse}")
	public ResponseEntity<Classe> buscarId(@PathVariable Long idClasse){
		return repository.findById(idClasse)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/tipoclasse/{tipoClasse}")
	public ResponseEntity<List<Classe>> buscarClasse(@PathVariable String tipoClasse){
		return ResponseEntity.ok(repository.findAllByTipoClasseContainingIgnoreCase(tipoClasse));
	}
	
	@PutMapping
	public ResponseEntity<Classe> put (@Valid @RequestBody Classe oClasse){
		return ResponseEntity.ok(repository.save(oClasse));
	}
	
	@PostMapping
	public ResponseEntity<Classe> post (@Valid @RequestBody Classe oClasse){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(oClasse));
	}
	
	@DeleteMapping("/{idClasse}")
	public void delete(@PathVariable Long idClasse) {
		repository.deleteById(idClasse);
	}
}