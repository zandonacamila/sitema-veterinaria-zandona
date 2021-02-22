package br.com.clinicazandona.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicazandona.models.Consulta;
import br.com.clinicazandona.repositories.ConsultaRepository;
import br.com.clinicazandona.repositories.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;

}
