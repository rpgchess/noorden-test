package br.vaga.noorden.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Basic(optional = false)
	@Column(name = "venda_id", unique = true, updatable = false, nullable = false) private long id;
	
	@Column(name = "cod_cliente", nullable = false) private long codCliente;
	@Column(name = "cod_produto", nullable = false) private long codProduto;
	@Column(name = "valor_total", nullable = false) private Double valorTotal;
	
	public long getId() 			{ return id; }
	public long getCodCliente() 	{ return codCliente; }
	public long getCodProduto() 	{ return codProduto; }
	public Double getValorTotal() 	{ return valorTotal; }
	
	public void setId(long id) 						{ this.id = id; }
	public void setCodCliente(long codCliente) 		{ this.codCliente = codCliente; }
	public void setCodProduto(long codProduto) 		{ this.codProduto = codProduto; }
	public void setValorTotal(Double valorTotal) 	{ this.valorTotal = valorTotal; }
}