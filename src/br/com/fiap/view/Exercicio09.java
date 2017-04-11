package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.entity.Pacote;

public class Exercicio09 {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		PacoteDAO dao = new PacoteDAOImpl(em);
		
		long x = dao.buscarQTDPorData(
				new GregorianCalendar(2017,Calendar.APRIL,1),
				new GregorianCalendar(2017,Calendar.DECEMBER,1));
		
		System.out.println(x);
		
		em.close();
		System.exit(0);

	}

}
