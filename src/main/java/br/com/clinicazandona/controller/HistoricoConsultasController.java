package br.com.clinicazandona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.clinicazandona.models.Consulta;
import br.com.clinicazandona.services.ConsultaService;

@Controller
public class HistoricoConsultasController {
	
	@Autowired
	private ConsultaService consultaService;

	@GetMapping("/historicoDeConsultasFinalizadas")
	public String retornaConsultasFinalizadas(@ModelAttribute Consulta consulta, Model model) {
		List<Consulta> consultas = consultaService.buscaConsultasFinalizadas();
		model.addAttribute("consultas", consultas);
		return "historicoDeConsultasFinalizadas";
	}
	
	@RequestMapping("/detalhesConsulta")
	public String retornaDetalhesConsulta(@RequestParam(value="id", required = false) Integer id, @ModelAttribute Consulta consulta, Model model) {
		Consulta consultaEmDetalhes = consultaService.buscaPorId(id);
		model.addAttribute(consultaEmDetalhes);
		return "detalhesConsultaFinalizada";
	}
}
