package br.com.clinicazandona.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Medico {

	@Id
	private Integer crv;
	private String nome;
	
	@OneToMany
	private List<Especie> especies;
	
	@OneToMany
	@JoinColumn(name = "medico")
	private List<Especialidade> especialidades;
	
	private String rua;
	private Integer numero;
	private String endereco_complemento;
	private String telefone;
	
	
	public void addEspecialidade(Especialidade especialidade)
	{
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
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return endereco_complemento;
	}
	public void setComplemento(String complemento) {
		this.endereco_complemento = complemento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
