package br.com.clinicazandona.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicazandona.models.Animal;
import br.com.clinicazandona.models.Consulta;
import br.com.clinicazandona.models.Especialidade;
import br.com.clinicazandona.models.Exame;
import br.com.clinicazandona.models.Medicamento;
import br.com.clinicazandona.models.Medico;
import br.com.clinicazandona.models.Tratamento;
import br.com.clinicazandona.repositories.AnimalRepository;
import br.com.clinicazandona.repositories.ConsultaRepository;
import br.com.clinicazandona.repositories.EspecialidadeRepository;
import br.com.clinicazandona.repositories.ExameRepository;
import br.com.clinicazandona.repositories.MedicamentoRepository;
import br.com.clinicazandona.repositories.MedicoRepository;
import br.com.clinicazandona.repositories.TratamentoRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private ExameRepository exameRepository;
	
	@Autowired
	private MedicamentoRepository medicamentoRepository;
	
	@Autowired
	private TratamentoRepository tratamentoRepository;
	
	public void salva(Consulta consulta) {
		consultaRepository.save(consulta);		
	}
	
	public void atualizaConsulta(Consulta consulta, Integer idAnimal, Integer idTratamento) {
		//Animal animalDaConsulta = animalRepository.getOne(consulta.getAnimal().getId());
		//animalRepository.save(animalDaConsulta);
//		consulta.setValor(getValorConsulta(consulta));
//		Consulta consultaAAlterar = consultaRepository.getOne(consulta.getId());
//		consultaAAlterar.setDiagnostico(consultaAAlterar.getDiagnostico());
		consulta.getAnimal().setId(idAnimal);
		consulta.getTratamento().setId(idTratamento);
		consulta.getTratamento().setMedicamento(consulta.getTratamento().getMedicamento());
		consultaRepository.save(consulta);
	}
	
	public void salvaExame(Exame exame) {
		exameRepository.save(exame);
	}

	public List<Consulta> buscaTodasConsultas() {
		List<Consulta> consultas = consultaRepository.findAll();
		return consultas;
	}
	
	
	public List<Consulta> buscaConsultasFinalizadas() {
		List<Consulta> consultas = consultaRepository.findAll();
		List<Consulta> consultasFinalizadas = consultas.stream().filter(c->c.getDiagnostico() != null).collect(Collectors.toList());
		return consultasFinalizadas;
	}


	public Consulta buscaPorId(Integer id) {
		Consulta consulta = null;
		Optional<Consulta> consultaAchada = consultaRepository.findById(id);
		return consultaAchada.orElse(consulta);
	}
	
	public void deletaPorId(Integer id) {
		consultaRepository.deleteById(id);
	}
	
	public List<Especialidade> buscaEspecialidades() {
		return especialidadeRepository.findAll();
	}
	
	public List<Medico> buscaProfissionais() {
		return medicoRepository.findAll();
	}
	
	public List<Animal> buscaAnimais() {
		return animalRepository.findAll();
	}
	
	public Animal buscaAnimalPorCpf(String cpf) {
		return animalRepository.findByCpfDono(cpf);
	}
	
	public List<Exame> buscaExames() {
		return exameRepository.findAll();
	}

	public List<Medicamento> buscaMedicamentos() {
		return medicamentoRepository.findAll();
	}
		
	public void calculaConsulta(Consulta consulta) {
		Optional<Especialidade> especialidadeConsulta = especialidadeRepository.findById(consulta.getMedico().getEspecialidades().get(0).getId());
		Especialidade especialidade = especialidadeConsulta.get();
		
		Double valor = especialidade.getValor() + consulta.getAtendimentoTipo().getValor();
		consulta.setValor(valor);
	}
	
	public List<Tratamento> buscaTratamentos() {
		return tratamentoRepository.findAll();
	}

}
