package entity.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;


@Entity
@NamedQuery(name="Registration.findAll",query="SELECT r FROM Registration r")
public class Registration implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reg_id")
	private int id;
	private LocalDate regDate;
	private int paidAmt;
	
	
	@ManyToOne
	@JoinColumn(name = "classes_id", referencedColumnName = "class_id")
	private Class classes;
	
	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "stu_id")
	private Student student;
	

	public Registration() {
		super();
	}

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getRegDate() {
		return regDate;
	}


	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}


	public int getPaidAmt() {
		return paidAmt;
	}


	public void setPaidAmt(int paidAmt) {
		this.paidAmt = paidAmt;
	}


	public Class getClasses() {
		return classes;
	}


	public void setClasses(Class classes) {
		this.classes = classes;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
   
}
