package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;

public interface GenericDAO<T,K> {

	void cadastrar(T entity);
	void alterar(T entity);
	void remover(K codigo) throws IdNotFoundException;
	T pesquisar(K codigo);
	void salvar() throws DBException;
	public List<T> listar2();
	public List<T> buscarPor1(Class entity, String AtributeName);
	public List<T> buscarPor2(T entity);
	
	
}
