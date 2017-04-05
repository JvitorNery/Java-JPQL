package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public List<Pacote> listar(){
		TypedQuery<Pacote> query = em.createQuery("from Pacote",Pacote.class);
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorPreco(float minimo, float maximo) {
		TypedQuery<Pacote> query = em.createQuery("from Pacote p where p.preco between :min and :max",Pacote.class);
		query.setParameter("min", minimo);
		query.setParameter("max", maximo);		
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorTransporte(Transporte transporte) {
		TypedQuery<Pacote> query = em.createQuery(
			"from Pacote p where p.transporte = :tr",Pacote.class);
		query.setParameter("tr", transporte);
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorDataSaida(Calendar inicio, Calendar fim) {
		TypedQuery<Pacote> query = em.createQuery("from Pacote p where p.dt_saida between :min and :max",Pacote.class);
		query.setParameter("min", inicio);
		query.setParameter("max", fim);		
		return query.getResultList();
	}
	

}
