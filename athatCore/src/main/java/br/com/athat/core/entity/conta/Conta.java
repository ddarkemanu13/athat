package br.com.athat.core.entity.conta;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.athat.core.entity.AbstractEntity;
import br.com.athat.core.entity.movimentacao.Movimentacao;

@MappedSuperclass
public class Conta extends AbstractEntity {
	private BigDecimal valorTotal = BigDecimal.ZERO;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Parcela> parcelas;
	@OneToOne
	private Movimentacao movimentacao;
	
	private SituacaoContaType situacao;

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	public Movimentacao getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public SituacaoContaType getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoContaType situacao) {
		this.situacao = situacao;
	}
	
	
	
	
}
