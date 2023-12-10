package br.edu.ifce.tjw.projetotjw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@PostMapping("/save-pessoa")
	public String salvarPessoa(@ModelAttribute("pessoa") Pessoa pessoa) {
		pessoaRepo.save(pessoa);
		return "redirect:/";
	}
}