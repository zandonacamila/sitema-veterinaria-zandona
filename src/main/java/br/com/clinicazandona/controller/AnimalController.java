package br.com.clinicazandona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.clinicazandona.models.Animal;
import br.com.clinicazandona.models.Especie;
import br.com.clinicazandona.repositories.AnimalRepository;
import br.com.clinicazandona.repositories.EspecieRepository;
import br.com.clinicazandona.services.AnimalService;
import br.com.clinicazandona.services.EspecieService;

@Controller
public class AnimalController {

	@Autowired
	private EspecieService especieService;
	
	@Autowired
	private AnimalService animalService;

	
	@GetMapping("/novoAnimal")
	public String chamaAnimal(@ModelAttribute Animal animal, Model model, @ModelAttribute Especie especie) {
		List<Especie> especies = especieService.buscaEspecies();
		model.addAttribute("especies", especies);
		return "novoAnimal";
	}
	
	@GetMapping("/animaisCadastrados")
	public String chamaAnimais(@ModelAttribute Animal animal, Model model, @ModelAttribute Especie especie) {
		List<Especie> especies = especieService.buscaEspecies();
		List<Animal> animais = animalService.buscaAnimais();
		model.addAttribute("especies", especies);
		return "/animaisCadastrados";
	}

	@PostMapping("/cadastraAnimal")
	public String cadastraNovoAnimal(@ModelAttribute Animal animal, Model model, RedirectAttributes redirAttrs) {
		animalService.salva(animal);
		redirAttrs.addFlashAttribute("message", "Animal cadastrado com sucesso!");
		return "redirect:/novoAnimal";
	}
}
