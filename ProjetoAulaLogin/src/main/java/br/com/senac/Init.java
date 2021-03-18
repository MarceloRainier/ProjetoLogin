package br.com.senac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.senac.dominio.Aluno;
import br.com.senac.dominio.Usuario;
import br.com.senac.repositorio.AlunoRepositorio;
import br.com.senac.repositorio.UsuarioRepositorio;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	AlunoRepositorio alunoRepo;
	
	@Autowired
	UsuarioRepositorio usuRepo;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		Aluno aluno = new Aluno("marcelo.rainier@hotmail.com", "Marcelo");
		
		alunoRepo.save(aluno);
		
		Usuario usu = new Usuario();
		usu.setLogin("marcelo");
		usu.setSenha(new BCryptPasswordEncoder().encode("123456"));
		
		usuRepo.save(usu);
	}

}
