package br.com.clinicazandona.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String data;
	private String hora;
	
	@OneToOne
	private Medico medico;
	
	@OneToOne
	private Animal animal;
	
	@OneToOne
	private Exame exame;
	private String diagnostico;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Tratamento tratamento;
	
	private Double valor;
	
	@ManyToOne
	private Atendimento atendimentoTipo;
	
	
	public Atendimento getAtendimentoTipo() {
		return atendimentoTipo;
	}
	public void setAtendimentoTipo(Atendimento atendimentoTipo) {
		this.atendimentoTipo = atendimentoTipo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Exame getExame() {
		return exame;
	}
	public void setExame(Exame exame) {
		this.exame = exame;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public Tratamento getTratamento() {
		return tratamento;
	}
	public void setTratamento(Tratamento tratamento) {
		this.tratamento = tratamento;
	}


}





//
//public Double getValorTotal() {
//	Double soma = exame.getValor();
//	
//	Double precoTratamento = tratamento.getMedicamento().getValorPorCaixa() *
//							 tratamento.getMedicamento().getQuantidadeEmCaixas();
//	this.valor = soma + precoTratamento;
//	
//	if(atendimentoTipo.equals("emergencia")) {
//		this.valor = this.valor*2.0;
//	} else {
//		this.valor = this.valor*1.25;
//	}
//	
//	return valor;
//}
