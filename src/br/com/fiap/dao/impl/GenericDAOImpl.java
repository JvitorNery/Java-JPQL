package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;

public class GenericDAOImpl<T,K> implements GenericDAO<T, K>{

	protected EntityManager em;
	
	//.class da entidade (usado na busca)
	private Class<T> classe;
	
	//Construtor
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		classe = (Class<T>) ((ParameterizedType)getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entity) {
		em.persist(entity);
	}

	@Override
	public void alterar(T entity) {
		em.merge(entity);
	}

	@Override
	public void remover(K codigo) throws IdNotFoundException {
		T entidade = pesquisar(codigo);
		if (entidade == null){
			throw new IdNotFoundException("Entidade não encontrada");
		}
		em.remove(entidade);
	}

	@Override
	public T pesquisar(K codigo) {
		return em.find(classe, codigo);
	}
	
	public void salvar() throws DBException{
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new DBException("Erro no commit", e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listar2() {
		String classeName = classe.getTypeName();
			TypedQuery<T> query = em.createQuery("from "+classe.getName(),classe);
			return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> buscarPor1(Class entity, String atributeName) {
		//Class clazze2 = entity.getClass();
		
		//TypedQuery<T> queryTrue = em.createQuery("from "+clazze2.getName()+" p where p."+atributeName+" = :parameter",clazze2);
		TypedQuery<T> queryTrue = em.createQuery("from "+entity.getName()+" p where p."+atributeName+" = :parameter",entity);
		queryTrue.setParameter("parameter", atributeName);
		
			return queryTrue.getResultList();	
	}

	@Override
	public List<T> buscarPor2(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
