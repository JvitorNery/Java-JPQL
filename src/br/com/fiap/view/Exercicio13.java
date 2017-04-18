package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;

public class Exercicio13 {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ClienteDAO dao = new ClienteDAOImpl(em);
		
		List<Cliente> cliente = dao.buscarPorDataAniversarioMes(2);
		
		for(Cliente cli : cliente){
			System.out.println(cli.getNome() + " " + cli.getEndereco().getCidade().getNome());
		}
			em.close();
			System.exit(0);
	}

}
