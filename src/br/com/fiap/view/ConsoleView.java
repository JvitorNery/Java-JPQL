package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class ConsoleView {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		PacoteDAO dao = new PacoteDAOImpl(em);
		List<Pacote> pacotes = dao.listar();
		
		List<Pacote> pacotes2 = dao.buscarPorPreco(100, 5000);
				
		for(Pacote pacote : pacotes){
			System.out.println(pacote.getDescricao() + "R$ "+pacote.getPreco()+" "+pacote.getQtdDias());
		}
		System.out.println("\n\n\n pacote listado por preço \n\n\n");
		for(Pacote pacote : pacotes2){
			System.out.println(pacote.getDescricao() + "R$ "+pacote.getPreco()+" "+pacote.getQtdDias());
		}
		
		System.out.println("\n\n\n Listar todos so clientes \n\n\n");
		
		ClienteDAO daoCli = new ClienteDAOImpl(em);
		List<Cliente> clientes = daoCli.listar();
		
		for(Cliente cli : clientes){
			System.out.println(cli.getId() + " nome: "+cli.getNome()+" cpf: "+cli.getCpf());
		}
		
		List<Cliente> clientes2 = daoCli.listar2();
		
		for(Cliente cli : clientes2){
			System.out.println(cli.getId() + " nome: "+cli.getNome()+" cpf: "+cli.getCpf());
		}
		
		Transporte transporte = new Transporte("COMETA");
		
		List<Pacote> pacotes3 = dao.buscarPorTransporte(transporte);
		
		/*if(pacotes3 != null){
			for(Pacote pacote : pacotes3){
				System.out.println(pacote.getDescricao());
			}
		}*/
		
		//List<Pacote> pacotes4 = dao.buscarPor1(transporte.getClass(), transporte.getEmpresa());
		
		//List<Pacote> pacotes4 = dao.buscarPorDataSaida(new GregorianCalendar(15,Calendar.APRIL ,2008),new GregorianCalendar(20,Calendar.APRIL ,2008));
		
		em.close();
		System.exit(0);
	}

}
