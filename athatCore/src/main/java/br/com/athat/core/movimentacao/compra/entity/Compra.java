package br.com.athat.core.movimentacao.compra.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.athat.core.cadastro.pessoa.fornecedor.entity.Fornecedor;
import br.com.athat.core.movimentacao.Movimentacao;

@Entity
public class Compra extends Movimentacao{

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false , length=100)
	private String notaFiscal;
	
	@Temporal(TemporalType.DATE)
	private Date dataEmissaoNF;	
	
	@Temporal(TemporalType.DATE)
	private Date previsaoEntrega;
	
	@ManyToOne
	private Fornecedor fornecedor;

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Date getDataEmissaoNF() {
		return dataEmissaoNF;
	}

	public void setDataEmissaoNF(Date dataEmissaoNF) {
		this.dataEmissaoNF = dataEmissaoNF;
	}

	public Date getPrevisaoEntrega() {
		return previsaoEntrega;
	}

	public void setPrevisaoEntrega(Date previsaoEntrega) {
		this.previsaoEntrega = previsaoEntrega;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

}