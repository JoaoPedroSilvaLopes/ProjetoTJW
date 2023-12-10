package br.edu.ifce.tjw.projetotjw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		return "index";
	}
}