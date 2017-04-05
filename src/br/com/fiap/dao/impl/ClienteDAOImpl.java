package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> listar() {
		TypedQuery<Cliente> query = em.createQuery("from Cliente",Cliente.class);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorDiasDaReserva(int minimo, int maximo) {
		TypedQuery<Cliente> query = em.createQuery("from Pacote p where p.preco between :min and :max",Cliente.class);
		query.setParameter("min", minimo);
		query.setParameter("max", maximo);		
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstado(String estado) {
		// TODO Auto-generated method stub
		return null;
	}

}
