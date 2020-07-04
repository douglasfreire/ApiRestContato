package com.douglas.freire.resource;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.freire.model.Contato;
import com.douglas.freire.repository.ContatoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/contatos")
@Api(value = "Api Rest Contato")
@CrossOrigin(origins = "*")
public class ContatoResource {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	
	@ApiOperation(value = "Adiciona um novo contato ")
	@PostMapping
	@ResponseBody
	public Contato create(@Valid @RequestBody Contato contato) {
		return contatoRepository.save(contato);
		
	}
	@ApiOperation(value = "Lista todos os contatos")
	@GetMapping(produces = "application/json")
	@ResponseBody
	public List<Contato> listaContatos(){
		return contatoRepository.findAll();
		
	}
	@ApiOperation(value = "Lista os contatos pelo id")
	@GetMapping(value = "/{id}", produces = "application/json")
	@ResponseBody
	public Contato listaContatoId(@PathVariable(value = "id") Long id) {
		return contatoRepository.findByid(id);
	}
	@ApiOperation(value = "Remove um contato cadastrado ")
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteContato(@PathVariable("id") Long id) {
		contatoRepository.deleteById(id);
		
	}
	@ApiOperation(value = "Atualiza os daados do contato ")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Contato> updateContato(@Valid @PathVariable(value = "id") Long id, @RequestBody Contato newContato) {		
		Optional<Contato> oldContato = contatoRepository.findById(id);
		if (oldContato.isPresent()){
			Contato contato = oldContato.get();
			contato.setNome(newContato.getNome());
			contato.setEmail(newContato.getEmail());
			contato.setTelefone(newContato.getTelefone());
			contatoRepository.save(contato);
			
			return new ResponseEntity<Contato>(contato, HttpStatus.OK);
		} 
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
