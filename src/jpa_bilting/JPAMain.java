/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_bilting;

/**
 *
 * @author User
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class JPAMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPADemo");
		
		EntityManager em = emf.createEntityManager();	
		em.getTransaction().begin();
		Person p = em.find(Person.class, 3);
		p.setCity("Skellefteå");
		System.out.println(p);
		em.getTransaction().commit();
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Person ppp = new Person(0,"Pelle",1967,"Malmö");
		em.persist(ppp);
		System.out.println("pelleid = " + ppp.getId());
		List<Person> list = em.createQuery("from Person", Person.class)
				.getResultList();
		System.out.println(list);
		em.getTransaction().commit();
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		list = em.createQuery("from Person p where p.name = :namn", Person.class)
				.setParameter("namn", "Pelle").getResultList();
		for (Person pp : list) {
			em.remove(pp);
		}
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
		

	}

}

