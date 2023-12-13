package br.edu.ifce.tjw.projetotjw.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifce.tjw.projetotjw.domain.Pessoa;
import br.edu.ifce.tjw.projetotjw.repository.CidadeRepository;
import br.edu.ifce.tjw.projetotjw.repository.DepartamentoRepository;
import br.edu.ifce.tjw.projetotjw.repository.PessoaRepository;
import jakarta.validation.Valid;

@Controller
public class PessoaController {

	private PessoaRepository pessoaRepo;
	private CidadeRepository cidadeRepo;
	private DepartamentoRepository departamentoRepo;

	public PessoaController(PessoaRepository pessoaRepo, CidadeRepository cidadeRepo, DepartamentoRepository departamentoRepo) {
		this.pessoaRepo = pessoaRepo;
		this.cidadeRepo = cidadeRepo;
		this.departamentoRepo = departamentoRepo;
	}

	@GetMapping("/")
	public String pessoas(Model model) {
		model.addAttribute("listaPessoas", pessoaRepo.findAll());
		return "/pessoas/index";
	}
	
	@GetMapping("/add-pessoa")
	public String adicionarPessoa(Model model) {
		model.addAttribute("pessoa", new Pessoa(""));
		model.addAttribute("cidades", cidadeRepo.findAll());
		model.addAttribute("departamentos", departamentoRepo.findAll());
		model.addAttribute("titulo", "Adicionar");
		return "/pessoas/form";
	}
	
	@GetMapping("/update-pessoa/{id}")
	public String editarPessoa(@PathVariable("id") long id, Model model) {
		Optional<Pessoa> pessoaOpt = pessoaRepo.findById(id);
		if (pessoaOpt.isEmpty()) {
			throw new IllegalArgumentException("Pessoa inválida");
		}
		model.addAttribute("pessoa", pessoaOpt.get());
		model.addAttribute("cidades", cidadeRepo.findAll());
		model.addAttribute("departamentos", departamentoRepo.findAll());
		model.addAttribute("titulo", "Editar");
		return "/pessoas/form";
	}
	
	@PostMapping("/save-pessoa")
	public String salvarPessoa(@Valid @ModelAttribute("pessoa") Pessoa pessoa, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("cidades", cidadeRepo.findAll());
			model.addAttribute("departamentos", departamentoRepo.findAll());
			model.addAttribute("titulo", "Editar");
			return "/pessoas/form";
		}
		
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