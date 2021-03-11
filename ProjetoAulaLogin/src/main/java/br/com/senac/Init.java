package br.com.senac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.dominio.Aluno;
import br.com.senac.repositorio.AlunoRepositorio;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	AlunoRepositorio alunoRepo;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		Aluno aluno = new Aluno("marcelo.rainier@hotmail.com", "Marcelo");
		
		alunoRepo.save(aluno);
	}

}
