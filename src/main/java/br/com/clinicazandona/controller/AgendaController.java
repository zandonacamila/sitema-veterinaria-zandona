package br.com.clinicazandona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.clinicazandona.models.Consulta;
import br.com.clinicazandona.services.ConsultaService;

@Controller
public class AgendaController {

	@Autowired
	private ConsultaService consultaService = new ConsultaService();
	
	
	@GetMapping("/agenda")
	public String alteraConsulta(@ModelAttribute Consulta consulta, Model model) {
		List<Consulta> consultas = consultaService.buscaTodasConsultas();
		model.addAttribute("consultas", consultas);
		return "agenda";
	}
	
	@RequestMapping("/deletaConsulta")
	public String deletaConsulta(
			@RequestParam(value = "id", required = false) Integer id, 
			Model model) {
		consultaService.deletaPorId(id);
		return "redirect:/agenda";
	}
	
//	@PostMapping("/agenda")
//	public String editaDetalhesDaConsulta(@ModelAttribute Consulta consulta, Model model, RedirectAttributes redirAttrs) {
//		consultaService.salva(consulta);
//		redirAttrs.addFlashAttribute("message", "Consulta agendada com sucesso!");
//		return "redirect:/telaDoMedico";
//	}
}
