package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;

public class Exercicio10 {

	public static void main(String[] args) {

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		PacoteDAO dao = new PacoteDAOImpl(em);
		
		System.out.println("A contagem de pacotes entre 10/04/2017 e 10/11/2017 é de: "+dao.buscarQuantidade(new GregorianCalendar(2017,Calendar.APRIL,10), new GregorianCalendar(2017,Calendar.NOVEMBER,10)));
		em.close();
		System.exit(0);

	}

}
