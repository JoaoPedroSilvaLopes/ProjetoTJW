package br.edu.ifce.tjw.projetotjw.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifce.tjw.projetotjw.entitie.Pessoa;
import br.edu.ifce.tjw.projetotjw.repository.PessoaRepository;

@Controller
public class PessoaController {

	private PessoaRepository pessoaRepo;

	public PessoaController(PessoaRepository pessoaRepo) {
		this.pessoaRepo = pessoaRepo;
	}

	@GetMapping("/")
	public String pessoas(Model model) {
		model.addAttribute("listaPessoas", pessoaRepo.findAll());
		return "home-page";
	}
	
	@GetMapping("/add-pessoa")
	public String adicionarPessoa(@ModelAttribute("pessoa") Pessoa pessoa) {
		return "add-pessoa-page";
	}
	
	@GetMapping("/update-pessoa/{id}")
	public String editarPessoa(@PathVariable("id") long id, Model model) {
		Optional<Pessoa> pessoaOpt = pessoaRepo.findById(id);
		if (pessoaOpt.isEmpty()) {
			throw new IllegalArgumentException("Pessoa inválida");
		}
		model.addAttribute("pessoa", pessoaOpt.get());
		return "update-pessoa-page";
	}
	
	@PostMapping("/save-pessoa")
	public String salvarPessoa(@ModelAttribute("pessoa") Pessoa pessoa) {
		pessoaRepo.save(pessoa);
		return "redirect:/";
	}
	
	@GetMapping("/delete-pessoa/{id}")
	public String excluirPessoa(@PathVariable("id") long id) {
		Optional<Pessoa> pessoaOpt = pessoaRepo.findById(id);
		if (pessoaOpt.isEmpty()) {
			throw new IllegalArgumentException("Pessoa inválida");
		}
		pessoaRepo.delete(pessoaOpt.get());
		return "redirect:/";
	}
}