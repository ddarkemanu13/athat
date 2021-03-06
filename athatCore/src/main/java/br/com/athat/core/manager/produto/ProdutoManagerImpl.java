package br.com.athat.core.manager.produto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.produto.Produto;
import br.com.athat.core.entity.produto.estoque.Estoque;
import br.com.athat.core.manager.AbstractManagerImpl;
import br.com.athat.utils.validators.ValidatorUtils;

public class ProdutoManagerImpl extends AbstractManagerImpl implements ProdutoManager {

	private static final long serialVersionUID = 1L;

	@Transactional
	@Override
	public void salvar(Produto produto) {
		if(produto.getId() == null) {
			Estoque estoque = new Estoque();
			estoque.setProduto(produto);
			produto.setEstoque(estoque);
			getEntityManager().persist(produto);
		} else {
			getEntityManager().merge(produto);
		}	
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Produto> buscar(Produto produto) {
		Criteria criteria = createSession().createCriteria(Produto.class,"p");
		
		if(produto.getCategoria() != null && produto.getCategoria().getId() != null){
			criteria.createAlias("categoria", "c");
			criteria.add(Restrictions.eq("p.categoria.id", produto.getCategoria().getId()));
		}	
			
		if(ValidatorUtils.isNotEmptyAndNotNull(produto.getDescricao()))
			criteria.add(Restrictions.like("p.descricao", produto.getDescricao()));
		
		return criteria.list();
	}

	@Transactional(readOnly = false)
	@Override
	public Produto buscarPorId(Long id) {
		return getEntityManager().find(Produto.class, id);
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> buscarComEstoque(Produto produto) {
		Criteria criteria = createSession().createCriteria(Produto.class,"p")
			.createAlias("estoque", "e")
			.add(Restrictions.gt("e.quantidade", 1));
		;
		
		if(produto.getCategoria() != null && produto.getCategoria().getId() != null){
			criteria.createAlias("categoria", "c");
			criteria.add(Restrictions.eq("p.categoria.id", produto.getCategoria().getId()));
		}	
			
		if(ValidatorUtils.isNotEmptyAndNotNull(produto.getDescricao()))
			criteria.add(Restrictions.like("p.descricao", produto.getDescricao()));
		
		return criteria.list();
	}
}
