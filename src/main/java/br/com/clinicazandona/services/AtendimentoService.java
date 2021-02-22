package br.com.clinicazandona.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicazandona.models.Atendimento;
import br.com.clinicazandona.repositories.AtendimentoRepository;

@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	
	public List<Atendimento> buscaTiposAtendimento() {
		return atendimentoRepository.findAll();
	}
	
	public void salva(Atendimento atendimento) {
		atendimentoRepository.save(atendimento);
	}

}









//public List<Consulta> buscaTodasConsultas() {
//List<Consulta> consultas = consultaRepository.findAll();
//return consultas;
//}
//
//public List<Especialidade> buscaEspecialidades() {
//return especialidadeRepository.findAll();
//}
//
//public List<Medico> buscaProfissionais() {
//return medicoRepository.findAll();
//}
//
//public List<Animal> buscaAnimais() {
//return animalRepository.findAll();
//}
