package br.com.clinicazandona.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinicazandona.models.Especie;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer> {

}
