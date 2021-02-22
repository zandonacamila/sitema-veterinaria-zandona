package br.com.clinicazandona.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clinicazandona.models.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {

}
