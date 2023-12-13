package br.edu.ifce.tjw.projetotjw.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifce.tjw.projetotjw.domain.Departamento;
import br.edu.ifce.tjw.projetotjw.repository.DepartamentoRepository;
import jakarta.validation.Valid;

@Controller
public class DepartamentoController {
	private DepartamentoRepository departamentoRepo;

	public DepartamentoController(DepartamentoRepository departamentoRepo) {
		this.departamentoRepo = departamentoRepo;
	}

	@GetMapping("/departamento")
	public String departamentos(Model model) {
		model.addAttribute("listaDepartamentos", departamentoRepo.findAll());
		return "/departamentos/index";
	}

	@GetMapping("/add-departamento")
	public String adicionarDepartamento(Model model) {
		model.addAttribute("departamento", new Departamento("", "", ""));
		model.addAttribute("titulo", "Adicionar");
		return "/departamentos/form";
	}

	@GetMapping("/update-departamento/{id}")
	public String editarDepartamento(@PathVariable("id") long id, Model model) {
		Optional<Departamento> departamentoOpt = departamentoRepo.findById(id);
		if (departamentoOpt.isEmpty()) {
			throw new IllegalArgumentException("Departamento inválido");
		}
		model.addAttribute("departamento", departamentoOpt.get());
		model.addAttribute("titulo", "Editar");
		return "/departamentos/form";
	}

	@PostMapping("/save-departamento")
	public String salvarDepartamento(@Valid @ModelAttribute("departamento") Departamento departamento,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("titulo", "Editar");
			return "/departamentos/form";
		}

		departamentoRepo.save(departamento);
		return "redirect:/departamento";
	}

	@GetMapping("/delete-departamento/{id}")
	public String excluirPessoa(@PathVariable("id") long id) {
		Optional<Departamento> departamentoOpt = departamentoRepo.findById(id);
		if (departamentoOpt.isEmpty()) {
			throw new IllegalArgumentException("Departamento inválido");
		}
		departamentoRepo.delete(departamentoOpt.get());
		return "redirect:/departamento";
	}
}
