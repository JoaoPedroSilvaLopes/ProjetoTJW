package br.edu.ifce.tjw.projetotjw.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifce.tjw.projetotjw.entitie.Pessoa;
import br.edu.ifce.tjw.projetotjw.repository.PessoaRepository;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class InitialPopulate implements CommandLineRunner {
	@Autowired
	private PessoaRepository pessoaRepo;

	@Override
	public void run(String... args) throws Exception {
		Pessoa p1 = new Pessoa("João");
		p1.setDataNascimento(LocalDate.of(2002, 6, 4));
		p1.setEmail("joao@gmail.com");
		Pessoa p2 = new Pessoa("Pedro");
		p2.setDataNascimento(LocalDate.of(2002, 6, 4));
		p2.setEmail("pedro@gmail.com");
		Pessoa p3 = new Pessoa("Vitória");
		p3.setDataNascimento(LocalDate.of(2003, 4, 11));
		p3.setEmail("vitoria@gmail.com");

		pessoaRepo.save(p1);
		pessoaRepo.save(p2);
		pessoaRepo.save(p3);
	}
}
