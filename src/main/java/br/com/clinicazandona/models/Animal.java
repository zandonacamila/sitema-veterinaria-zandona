package br.com.clinicazandona.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeAnimal;
	private String nomeDono;
	private String cpfDono;
	private String ruaDono;
	private String numeroDono;
	private String telefoneDono;
	
	@OneToOne
	private Especie especie;
	private Integer idadeAnimal;
	

	public String getNomeAnimal() {
		return nomeAnimal;
	}
	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}
	public Integer getIdadeAnimal() {
		return idadeAnimal;
	}
	public void setIdadeAnimal(Integer idadeAnimal) {
		this.idadeAnimal = idadeAnimal;
	}
	public String getNomeDono() {
		return nomeDono;
	}
	public void setNomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
	}
	public String getRuaDono() {
		return ruaDono;
	}
	public void setRuaDono(String ruaDono) {
		this.ruaDono = ruaDono;
	}
	public String getNumeroDono() {
		return numeroDono;
	}
	public void setNumeroDono(String numeroDono) {
		this.numeroDono = numeroDono;
	}
	public String getTelefoneDono() {
		return telefoneDono;
	}
	public void setTelefoneDono(String telefoneDono) {
		this.telefoneDono = telefoneDono;
	}
	public String getCpfDono() {
		return cpfDono;
	}
	public void setCpfDono(String cpfDono) {
		this.cpfDono = cpfDono;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Especie getEspecie() {
		return especie;
	}
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
	
	

	
}
