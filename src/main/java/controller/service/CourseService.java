package controller.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entity.model.Course;

public class CourseService {

	private EntityManager em;

	public CourseService(EntityManager em) {
		this.em = em;
	}

	public List<Course> findAll() {
		TypedQuery<Course> query = em.createNamedQuery("Course.getAll", Course.class);
		List<Course> list = query.getResultList();
		return list;
	}

	public void save(Course c) {
		em.getTransaction().begin();
		if (c.getId() == 0)// new category
			em.persist(c);
		else
			em.merge(c);// edit
		
		em.getTransaction().commit();
	}

	public Course findById(int id) {

		return em.find(Course.class, id);
	}

	public void delete(int id) {
		em.getTransaction().begin();
		Course course = em.find(Course.class, id);
		em.remove(course);
		em.getTransaction().commit();

	}
}
