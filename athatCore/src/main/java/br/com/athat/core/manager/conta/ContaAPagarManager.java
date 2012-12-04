package br.com.athat.core.manager.conta;

import br.com.athat.core.entity.conta.ContaAPagar;
import java.util.List;

import br.com.athat.core.entity.conta.Conta;
import br.com.athat.core.entity.movimentacao.compra.Compra;



public interface ContaAPagarManager {

	
	public void salvar(ContaAPagar contaAPagar);
	public List<Conta> buscarTodos(ContaAPagar conta);

	
	
	
}
