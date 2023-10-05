package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Birder;

/**
 * @author Amy Miles
 * CIS 175 - Fall 2023
 * Oct 4, 2023
 */
public class BirderHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BirdWatchingWeb");

	public void insertBirder(Birder b) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}

	public List<Birder> showAllBirders() {
			EntityManager em = emfactory.createEntityManager();
			List<Birder> allBirders = em.createQuery("SELECT b	FROM Birder b").getResultList();
			return allBirders;
	}
	
	public Birder findBirder(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Birder> typedQuery = em.createQuery("select b	from Birder sh where b.birderName = :selectedName",	Birder.class);
		
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		Birder foundBirder;
		try {
		foundBirder = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
		foundBirder = new Birder(nameToLookUp);
		}
		em.close();
		return foundBirder;
		}
		
}
