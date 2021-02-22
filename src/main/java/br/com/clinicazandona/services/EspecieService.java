package br.com.clinicazandona.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicazandona.models.Especie;
import br.com.clinicazandona.repositories.EspecieRepository;


@Service
public class EspecieService {

	@Autowired
	private EspecieRepository especieRepository;
	
	public List<Especie> buscaEspecies(){
		return especieRepository.findAll();
	}

}
