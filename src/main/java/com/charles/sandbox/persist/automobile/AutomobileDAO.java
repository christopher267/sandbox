package com.charles.sandbox.persist.automobile;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.charles.sandbox.persist.api.automobile.IAutomobileDAO;
import com.charles.sandbox.persist.dataobject.automobile.Automobile;

@Repository
public class AutomobileDAO implements IAutomobileDAO<Automobile> {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Automobile automobile) {
		em.persist(automobile);
	}

	@Override
	public void update(Automobile automobile) {
		em.merge(automobile);
	}

	@Override
	public void delete(Long id) {
		Automobile automobile = em.find(Automobile.class, id);
		em.remove(automobile);
	}

	@Override
	public Automobile get(String manufacturer, String model, Long year) {
		return em.createQuery(
		        "SELECT * FROM AUTOMOBILE a WHERE a.manufacturer = ?1, AND a.model = ?2, AND a.year = ?3", Automobile.class)
		        .setParameter(1, manufacturer)
		        .setParameter(2, model)
		        .setParameter(3, year)
		        .getSingleResult();
	}

	@Override
	public Automobile get(Long id) {
		return em.find(Automobile.class, id);
	}

	@Override
	public List<Automobile> get(List<Long> ids) {
		return em.createQuery("SELECT * FROM AUTOMOBILE a WHERE a.id in :inclList", Automobile.class)
				.setParameter("inclList", ids)
				.getResultList();
	}
}
