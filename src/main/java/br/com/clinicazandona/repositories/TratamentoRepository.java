package br.com.clinicazandona.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinicazandona.models.Tratamento;

@Repository
public interface TratamentoRepository extends JpaRepository<Tratamento, Integer>{
 
}
