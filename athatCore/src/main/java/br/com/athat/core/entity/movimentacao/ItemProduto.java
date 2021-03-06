package br.com.athat.core.entity.movimentacao;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import br.com.athat.core.entity.AbstractEntity;
import br.com.athat.core.entity.produto.Produto;

@Entity
public class ItemProduto extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private BigDecimal valor = BigDecimal.ZERO;
	
	private BigDecimal desconto = BigDecimal.ZERO;
	
	private int quantidade = 1;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Produto produto;
	
	public ItemProduto() {}

	public ItemProduto(ItemProduto itemProduto) {
		valor = itemProduto.getValor();
		desconto = itemProduto.getValor();
		quantidade = itemProduto.getQuantidade();
		produto = itemProduto.getProduto();
	}

	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getValorTotal() {
            BigDecimal total = valor.multiply(new BigDecimal(quantidade));
            if(desconto != null) {
                total = valor.subtract(desconto);
            }
            return total;
	}
	
	public BigDecimal getDesconto() {
		return desconto;
	}
	
	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}
}
