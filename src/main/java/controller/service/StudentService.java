package controller.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import entity.model.Student;

public class StudentService {
	private EntityManager em;

	public StudentService(EntityManager em) {
		this.em=em;
	}

	public List<Student> findAll() {
		TypedQuery<Student> query = em.createNamedQuery("Student.getAll",Student.class);
		return query.getResultList();

	}

	public void save(Student s) {
		em.getTransaction().begin();
		if (s.getId() == 0) {
			em.persist(s);
		} else {
			em.merge(s);
		}

		em.getTransaction().commit();

	}

	public Student findById(int id) {
		return em.find(Student.class, id);

	}

	public void delete(int id) {
		em.getTransaction().begin();
		Student stu = em.find(Student.class, id);
		em.remove(stu);
		em.getTransaction().commit();

	}
}
