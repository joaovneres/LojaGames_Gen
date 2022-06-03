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

import com.generation.loja_games.model.Personagem;
import com.generation.loja_games.repository.PersonagemRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/personagem")
public class PersonagemController {
	@Autowired
	private PersonagemRepository repository;

	@GetMapping
	public ResponseEntity<List<Personagem>> listar() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{idPersonagem}")
	public ResponseEntity<Personagem> buscarId(@PathVariable Long idPersonagem) {
		return repository.findById(idPersonagem).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nomepersonagem/{nomePersonagem}")
	public ResponseEntity<List<Personagem>> buscarNome(@PathVariable String nomePersonagem) {
		return ResponseEntity.ok(repository.findAllByNomePersonagemContainingIgnoreCase(nomePersonagem));
	}
	
	@PutMapping
	public ResponseEntity<Personagem> put (@Valid @RequestBody Personagem oPersonagem){
		return ResponseEntity.status(HttpStatus.OK)
					.body(repository.save(oPersonagem));
	}
	
	@PostMapping
	public ResponseEntity<Personagem> post (@Valid @RequestBody Personagem oPersonagem){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(oPersonagem));
	}
	
	@DeleteMapping("/{idPersonagem}")
	public void delete(@PathVariable Long idPersonagem) {
		repository.deleteById(idPersonagem);
	}
}
