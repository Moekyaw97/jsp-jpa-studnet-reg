package controller.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entity.model.Class;

public class ClassService {

	private EntityManager em;

	public ClassService(EntityManager em) {
		this.em=em;
	}

	public List<Class> findAll() {
		TypedQuery<Class> query = em.createNamedQuery("Class.findAll", Class.class);
		return query.getResultList();

	}

	public void save(Class classes) {
		em.getTransaction().begin();
		if (classes.getId() == 0) {
			em.persist(classes);
		} else {
			em.merge(classes);
		}

		em.getTransaction().commit();

	}

	public Class findById(int id) {
		return em.find(Class.class, id);

	}

	public void delete(int id) {
		em.getTransaction().begin();
		Class classes = em.find(Class.class, id);
		em.remove(classes);
		em.getTransaction().commit();

	}
}
