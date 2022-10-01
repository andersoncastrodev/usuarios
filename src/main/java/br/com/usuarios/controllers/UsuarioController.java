package br.com.usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.usuarios.domain.Usuario;
import br.com.usuarios.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id){
	
		Usuario usuario = this.usuarioService.findById(id);
		
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		
		List<Usuario> list = usuarioService.findAll();
		
		return ResponseEntity.ok().body(list);	
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario obj){
		
		Usuario newObj = usuarioService.update(id,obj);
		
		return ResponseEntity.ok().body(newObj);
	}
	
}
