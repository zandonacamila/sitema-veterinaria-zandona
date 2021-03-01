package br.com.clinicazandona.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Medico extends Pessoa {

	@Id
	private Integer crv;
	
	private String nome;
	
	@OneToMany
	private List<Especie> especies;
	
	@ManyToMany
	@JoinColumn(name = "medico")
	private List<Especialidade> especialidades;
	
	private String endereco_complemento;
	
	
	public void addEspecialidade(Especialidade especialidade) {
	    this.especialidades.add(especialidade);
	}


	public Integer getCrv() {
		return crv;
	}


	public void setCrv(Integer crv) {
		this.crv = crv;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<Especie> getEspecies() {
		return especies;
	}


	public void setEspecies(List<Especie> especies) {
		this.especies = especies;
	}


	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}


	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}


	public String getEndereco_complemento() {
		return endereco_complemento;
	}


	public void setEndereco_complemento(String endereco_complemento) {
		this.endereco_complemento = endereco_complemento;
	}

}
