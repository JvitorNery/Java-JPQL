package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer>{

	List<Pacote> listar();
	
	List<Pacote> buscarPorPreco(float maximo);
	
	List<Pacote> buscarPorTransporte(Transporte transporte);
	
	List<Pacote> buscarPorData(Calendar inicio, Calendar fim);
	
	double buscarPrecoMedio();
	
	long buscarQuantidade(Calendar inicio, Calendar fim);
	
	List<Pacote> buscarMaiorPreco();
}
