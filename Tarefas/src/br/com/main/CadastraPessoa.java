package br.com.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.model.Pessoa;

public class CadastraPessoa {
	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome("Marcelina Perreira");
		pessoa.setEmail("marcelina.perreira@hotmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidade");
		EntityManager manager = emf.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(pessoa);
		manager.getTransaction().commit();
		
		System.out.println("Cadastrado " + pessoa.getId());
		manager.close();
		emf.close();
	}

}
