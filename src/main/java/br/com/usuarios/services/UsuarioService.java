package br.com.usuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.usuarios.domain.Usuario;
import br.com.usuarios.exceptions.ObjectNotFoundException;
import br.com.usuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public Usuario findById(Integer id) {
		
		Optional<Usuario> obj = usuarioRepository.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto Não Encontrado! Id:"+id+",Tipo "+Usuario.class.getName()));
	}


	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario update(Integer id, Usuario obj) {
		Usuario newObj = findById(id);
		
		newObj.setNome(obj.getNome());
		newObj.setLogin(obj.getLogin());
		newObj.setSenha(obj.getSenha());
		
		return usuarioRepository.save(newObj);
	}


	public Usuario create(Usuario obj) {
		obj.setId(null); //Para Evitar Sobrescrever o dado já Existente.		
		return usuarioRepository.save(obj);
	}

	public void delete(Integer id) {
		findById(id); //buscando o objeto Usuario
		usuarioRepository.deleteById(id);
	}
}
