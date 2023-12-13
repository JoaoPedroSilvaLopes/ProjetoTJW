package br.edu.ifce.tjw.projetotjw.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifce.tjw.projetotjw.domain.Cidade;
import br.edu.ifce.tjw.projetotjw.domain.Departamento;
import br.edu.ifce.tjw.projetotjw.domain.Pessoa;
import br.edu.ifce.tjw.projetotjw.repository.CidadeRepository;
import br.edu.ifce.tjw.projetotjw.repository.DepartamentoRepository;
import br.edu.ifce.tjw.projetotjw.repository.PessoaRepository;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class InitialPopulate implements CommandLineRunner {
	@Autowired
	private PessoaRepository pessoaRepo;
	
	@Autowired
	private CidadeRepository cidadeRepo;
	
	@Autowired
	private DepartamentoRepository departamentoRepo;

	@Override
	public void run(String... args) throws Exception {
		
		Cidade cidade1 = new Cidade("Fortaleza", "CE");
		Cidade cidade2 = new Cidade("Aquiraz", "CE");
		
		cidadeRepo.save(cidade1);
		cidadeRepo.save(cidade2);
		cidadeRepo.flush();
		
		Departamento dep1 = new Departamento("Recusos Humanos", "RH", "Departamento responsável por gerir chamados relacionados à TI");
		Departamento dep2 = new Departamento("Tecnologia da Informação", "TI", "Departamento responsável por gerir chamados relacionados aos Recusos Humanos");
		
		departamentoRepo.save(dep1);
		departamentoRepo.save(dep2);
		departamentoRepo.flush();
		
		Pessoa p1 = new Pessoa("João");
		p1.setDataNascimento(LocalDate.of(2002, 6, 4));
		p1.setEmail("joao@gmail.com");
		p1.setCpf("065.574.773-74");
		p1.setCidade(cidade1);
		p1.setDepartamento(dep2);
		
		Pessoa p2 = new Pessoa("Pedro");
		p2.setDataNascimento(LocalDate.of(2002, 6, 4));
		p2.setEmail("pedro@gmail.com");
		p2.setCpf("065.574.773-74");
		p2.setCidade(cidade2);
		p2.setDepartamento(dep2);
		
		Pessoa p3 = new Pessoa("Vitória");
		p3.setDataNascimento(LocalDate.of(2003, 4, 11));
		p3.setEmail("vitoria@gmail.com");
		p3.setCpf("065.574.773-74");
		p3.setCidade(cidade2);
		p3.setDepartamento(dep1);

		pessoaRepo.save(p1);
		pessoaRepo.save(p2);
		pessoaRepo.save(p3);
	}
}
