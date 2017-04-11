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
	public List<Pacote> listar() {
		TypedQuery<Pacote> query = 
				em.createQuery("from Pacote",Pacote.class);
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorPreco(float maximo) {
		TypedQuery<Pacote> query = em.createQuery(
				"from Pacote p where p.preco < :pre",Pacote.class);
		query.setParameter("pre", maximo);
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorTransporte(Transporte transporte) {
		TypedQuery<Pacote> query = em.createQuery(
			"from Pacote p where p.transporte = :tr",Pacote.class);
		query.setParameter("tr", transporte);
		return query.getResultList();
		
	}
	
	public List<Pacote> buscarPorData(Calendar inicio, Calendar fim){
		return em.createQuery("from Pacote p where p.dataSaida between :i and :f", Pacote.class).setParameter("i",inicio).setParameter("f",fim).getResultList();
		
	}
	
	public long buscarQTDPorData(Calendar inicio, Calendar fim){
		return em.createQuery("select count(id) from Pacote p where p.dataSaida between :i and :f", Long.class).setParameter("i",inicio).setParameter("f",fim).getSingleResult();
		
	}

}










