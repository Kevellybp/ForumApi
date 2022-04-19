package com.api.forum.controller;



import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.forum.DTO.TopicoDTO;
import com.api.forum.DTO.TopicoForm;
import com.api.forum.model.Topico;
import com.api.forum.repository.CursoRepository;
import com.api.forum.repository.TopicoRepository;




@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository repository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	
@GetMapping
public ResponseEntity<List<Topico>> gettAll (){
	return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
		
	}
@GetMapping("/{id}")
public ResponseEntity<Object> getByIdTopico (@PathVariable Long id) {
	
	return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id));
}

	@PostMapping("/insert")
public ResponseEntity<Object> cadastrar (@RequestBody @Valid TopicoForm form) {
	Topico topico = form.converter(cursoRepository);
	return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(topico));
}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Object> atualizar (@PathVariable @RequestBody @Valid Long id, TopicoForm form){
		Optional<Topico> topico = repository.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(topico));
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?> remover (@PathVariable Long id) {
		repository.deleteById(id);
		return  ResponseEntity.status(HttpStatus.OK).build();
	}
}
