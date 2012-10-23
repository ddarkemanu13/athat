package br.com.athat.web.controller.produto;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.cadastro.produto.categoria.entity.Categoria;
import br.com.athat.core.cadastro.produto.categoria.manager.CategoriaManager;
import br.com.athat.core.cadastro.produto.entity.Produto;
import br.com.athat.core.cadastro.produto.manager.ProdutoManager;
import br.com.athat.web.utils.AbstractController;

public class ProdutoController extends AbstractController{
	
	private static final long serialVersionUID = 1L;

	private Produto produto;
    private List<Produto> produtos;
    private Categoria categoria;
    private List<Categoria> categorias;
    
    @Autowired
    private ProdutoManager produtoManager;
    
    @Autowired
    private CategoriaManager categoriaManager;

    public ProdutoController() {
        produto = new Produto();
        produto.setCategoria(new Categoria());
        produtos  = new ArrayList<Produto>();
        categoria = new Categoria();
        categorias = new ArrayList<Categoria>();
    }
    
    @PostConstruct
    public void init(){
		String id = getParametro("id");
		if (id != null) 
			produto = produtoManager.buscarPorId(Long.valueOf(id));
    }
    
    public String salvar (){
        produtoManager.salvar(produto);
        getMessageCadastroSucesso();
        
        return "cadastroProduto";
    }
    public void buscar(){
        produtos =  produtoManager.buscar(produto);
    }
    
    public void buscarCategoria(){
        setCategorias(categoriaManager.buscar(categoria));
    }

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
}