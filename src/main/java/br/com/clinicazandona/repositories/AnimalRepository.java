package br.com.clinicazandona.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinicazandona.models.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer>{

	
	public Animal findByCpfDono (String cpf); 
}
