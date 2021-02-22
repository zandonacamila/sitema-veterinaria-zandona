package br.com.clinicazandona.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinicazandona.models.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
