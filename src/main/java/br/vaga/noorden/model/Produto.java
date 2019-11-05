package br.vaga.noorden.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Basic(optional = false)
	@Column(name = "produto_id", unique = true, updatable = false, nullable = false) private long id;
	
	@Column(name = "nome", nullable = false) private String nome;
	@Column(name = "valor", nullable = false) private Double valor;
	
	public long getId() 		{ return id; }
	public String getNome() 	{ return nome; }
	public Double getValor() 	{ return valor; }
	
	public void setId(long id) 			{ this.id = id; }	
	public void setNome(String nome) 	{ this.nome = nome; }
	public void setValor(Double valor) 	{ this.valor = valor; }
}