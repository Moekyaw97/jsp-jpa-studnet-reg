package controller.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import entity.model.Registration;

public class RegistrationService {
	private EntityManager em;

	public RegistrationService(EntityManager em) {
		this.em=em;
	}

	public List<Registration> findAll() {
		TypedQuery<Registration> query = em.createNamedQuery("Registration.findAll", Registration.class);
		return query.getResultList();

	}

	public void save(Registration reg) {
		em.getTransaction().begin();
		if (reg.getId() == 0) {
			em.persist(reg);
		} else {
			em.merge(reg);
		}

		em.getTransaction().commit();

	}

	public Registration findById(int id) {
		return em.find(Registration.class, id);

	}

	public void delete(int id) {
		em.getTransaction().begin();
		Registration reg = em.find(Registration.class, id);
		em.remove(reg);
		em.getTransaction().commit();

	}
}
