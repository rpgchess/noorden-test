package br.vaga.noorden.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Basic(optional = false)
	@Column(name = "cliente_id", unique = true, updatable = false, nullable = false) private long id;
	
	@Column(name = "nome", nullable = false) private String nome;
	@Column(name = "cpf", unique = true, nullable = false) private String cpf;
	@Column(name = "data_nasc", nullable = false) private String dataNasc;
	@Column(name = "sexo", nullable = false) private String sexo;
	
	public long getId() 		{ return id; }
	public String getNome() 	{ return nome; }
	public String getCpf() 		{ return cpf; }
	public String getDataNasc() { return dataNasc; }
	public String getSexo() 	{ return sexo; }
	
	public void setId(long id) 					{ this.id = id; }
	public void setNome(String nome) 			{ this.nome = nome; }
	public void setCpf(String cpf) 				{ this.cpf = cpf; }
	public void setDataNasc(String dataNasc) 	{ this.dataNasc = dataNasc; }
	public void setSexo(String sexo) 			{ this.sexo = sexo; }
}