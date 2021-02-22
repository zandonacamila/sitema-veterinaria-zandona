package br.com.clinicazandona.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.clinicazandona.models.Animal;
import br.com.clinicazandona.models.Especie;
import br.com.clinicazandona.repositories.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private EspecieService especieService;

	public List<Animal> buscaAnimais() {
		return animalRepository.findAll();
	}

	public List<Animal> animaisDeUmaEspecie(List<Especie> especies, @RequestParam(value="action", required=true) String action) {
		switch(action) {
		case "save":
			// do stuff
			break;
		case "cancel":
			// do stuff
			break;
		case "newthing":
			// do stuff
			break;
		default:
			// do stuff
			break;
		} {
			List<Animal> animais = buscaAnimais();
			especies = especieService.buscaEspecies();
			return animais;
		}


	}

	public void salva(Animal animal) {
		animalRepository.save(animal);
		
	}
}
