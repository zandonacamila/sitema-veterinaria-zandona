package br.com.clinicazandona.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinicazandona.models.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer>{

}
