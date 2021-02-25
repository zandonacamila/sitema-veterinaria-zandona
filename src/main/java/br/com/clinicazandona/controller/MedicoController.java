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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.clinicazandona.models.Animal;
import br.com.clinicazandona.models.Atendimento;
import br.com.clinicazandona.models.Consulta;
import br.com.clinicazandona.models.Especialidade;
import br.com.clinicazandona.models.Exame;
import br.com.clinicazandona.models.Medicamento;
import br.com.clinicazandona.models.Medico;
import br.com.clinicazandona.models.Tratamento;
import br.com.clinicazandona.repositories.TratamentoRepository;
import br.com.clinicazandona.services.AnimalService;
import br.com.clinicazandona.services.AtendimentoService;
import br.com.clinicazandona.services.ConsultaService;

@Controller
public class MedicoController {

	@Autowired
	private ConsultaService consultaService = new ConsultaService();

	@Autowired
	private AtendimentoService atendimentoService;

	@Autowired
	private AnimalService animalService;

	@Autowired
	private TratamentoRepository tratamentoRepository;


	@GetMapping("/telaDoMedico")
	public String alteraConsulta(@ModelAttribute Consulta consulta, Model model) {
		List<Consulta> consultas = consultaService.buscaTodasConsultas();
		List<Exame> exames = consultaService.buscaExames();
		model.addAttribute("consultas", consultas);
		return "telaDoMedico";
	}


	@RequestMapping("/alteraConsulta")
	public String carregaAlterar(@RequestParam(value="id", required = false) Integer id,
			Model model,
			RedirectAttributes redirectAtt) {
		
		Consulta consulta = consultaService.buscaPorId(id);
		List<Atendimento> tiposAtendimento = atendimentoService.buscaTiposAtendimento();
		List<Medico> medicos = consultaService.buscaProfissionais();
		List<Exame> exames = consultaService.buscaExames();
		List<Especialidade> especialidades = consultaService.buscaEspecialidades();
		List<Tratamento> tratamentos = consultaService.buscaTratamentos();
		List<Medicamento> medicamentos = consultaService.buscaMedicamentos();
		model.addAttribute("consultas", consultaService.buscaTodasConsultas());
		model.addAttribute("consulta", consulta);
		model.addAttribute("exames", exames);
		model.addAttribute("medicos", medicos);
		model.addAttribute("medicamentos", medicamentos);
		model.addAttribute("tiposAtendimento", tiposAtendimento);
		model.addAttribute("especialidades", especialidades);
		model.addAttribute("tratamentos", tratamentos);

		return "alteraConsulta";
	}

	@PostMapping("/consultaAlterada")
	public String cadastraConsultaAlterada(
			@RequestParam(value="id", required = false) Integer id, 
			@RequestParam(value="idAnimal", required = false) Integer idAnimal,
			@RequestParam(value="idTratamento", required = false) Integer idTratamento,
			@ModelAttribute Consulta consulta, 
			@ModelAttribute Animal animal, 
			@ModelAttribute Especialidade especialidade, 
			@ModelAttribute Tratamento tratamento, 
			Model model, 
			RedirectAttributes redirAttrs) {
		
		try {
			consultaService.atualizaConsulta(consulta, idAnimal, idTratamento);
			redirAttrs.addFlashAttribute("message", "Consulta alterada com sucesso!");
		} catch (Exception e) {
			redirAttrs.addFlashAttribute("errorMessage",e.getMessage());
		}

		return "redirect:/telaDoMedico";
	}
}
