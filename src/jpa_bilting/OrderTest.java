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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OrderTest {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPADemo");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Order o = em.find(Order.class, 0);
		System.out.println(o);
		em.getTransaction().commit();
		
		emf.close();
	}
	

}
