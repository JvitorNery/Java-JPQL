package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;

public class Exercicio12 {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ClienteDAO dao = new ClienteDAOImpl(em);
		
		Cliente cli = dao.buscarPorCPF("98728018736");
		
		
			System.out.println(cli.getNome() + " " + cli.getEndereco().getCidade().getNome());
		
			em.close();
			System.exit(0);
	}

}
