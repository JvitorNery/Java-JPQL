package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.entity.Pacote;

public class ConsoleView {

	public static void main(String[] args) {
		//Chamar o listar do PacoteDAO e exibir os pacotes
		EntityManager em = EntityManagerFactorySingleton.getInstance()
													.createEntityManager();
		PacoteDAO dao = new PacoteDAOImpl(em);
		List<Pacote> pacotes = dao.listar();
		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao() + " R$" + 
					pacote.getPreco() + " " + pacote.getQtdDias());
		}
		
		//Buscar os pacotes pelo preço máximo
		List<Pacote> lista = dao.buscarPorPreco(2100);
		for (Pacote pacote : lista) {
			System.out.println(pacote.getDescricao() + " R$" + 
					pacote.getPreco() + " " + pacote.getQtdDias());
		}
		
		em.close();
		System.exit(0);
		
	}

}
