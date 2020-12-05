/**
 * 
 */
package br.com.projeto.db;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * api-rest
 * @author jaime
 * 29 de nov de 2020
 * https://github.com/jaimedessilva/api-user-rest
 */
@ApplicationScoped
public class JpaUtil {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("api-rest");
	EntityManager em;
	
	/* EntityManager */
	public EntityManager getEntityManager() {
		return em = emf.createEntityManager();
	}
	/* Construct */
	public JpaUtil() {
		System.out.println("Connect.....");
		getEntityManager();
		
	}
	public void JpaClose() {
		em.close();
	}
}
