package br.com.usuarios;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.usuarios.domain.Usuario;
import br.com.usuarios.repository.UsuarioRepository;

@SpringBootApplication
public class UsuariosApplication implements CommandLineRunner  {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UsuariosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Joao", "Joao", "123456");
		
		Usuario u2 = new Usuario(null, "Pedro", "Perdo", "123456");
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
			
	}

	
}
