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
import br.com.clinicazandona.models.Atendimento;
import br.com.clinicazandona.models.Consulta;
import br.com.clinicazandona.models.Especialidade;
import br.com.clinicazandona.models.Medico;
import br.com.clinicazandona.services.AtendimentoService;
import br.com.clinicazandona.services.ConsultaService;

@Controller
public class ConsultaController {
	
	@Autowired
	private ConsultaService consultaService = new ConsultaService();
	
	@Autowired
	private AtendimentoService atendimentoService;


	@GetMapping("/novaConsulta")
	public String novaConsulta(@ModelAttribute Consulta consulta, Model model, @ModelAttribute Atendimento atendimento) {
		List<Atendimento> tiposAtendimento = atendimentoService.buscaTiposAtendimento();
		List<Consulta> consultas = consultaService.buscaTodasConsultas();
		List<Medico> medicos = consultaService.buscaProfissionais();
		List<Especialidade> especialidades = consultaService.buscaEspecialidades();
		List<Animal> animais = consultaService.buscaAnimais();
		model.addAttribute("especialidades", especialidades);
		model.addAttribute("medicos", medicos);
		model.addAttribute("consultas", consultas);
		model.addAttribute("animais", animais);
		model.addAttribute("tiposAtendimento", tiposAtendimento);
		return "novaConsulta";
	}

	@PostMapping("/agendaNovaConsulta")
	public String cadastraNovaConsulta(@ModelAttribute Consulta consulta, Model model, RedirectAttributes redirAttrs) {
		try {
			consultaService.calculaConsulta(consulta);
			consultaService.salva(consulta);
			redirAttrs.addFlashAttribute("message", "Consulta agendada com sucesso!");
		} catch(Exception e) {
			redirAttrs.addFlashAttribute("errorMessage",e.getMessage());
		}
			return "redirect:/novaConsulta";
	}
	
}
