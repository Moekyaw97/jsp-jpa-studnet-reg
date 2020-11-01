package entity.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;



@Entity
@NamedQuery(name="Class.findAll",query="SELECT c FROM Class c")
public class Class implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "class_id")
	private int id;
	private String name;
	private LocalDate start_date;

	
	@ManyToOne
	@JoinColumn(name = "courses_id", referencedColumnName = "course_id")
	private Course course;
	
	
	@OneToMany(mappedBy = "classes")
	private List<Registration> regs;
	public Class() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Registration> getRegs() {
		return regs;
	}

	public void setRegs(List<Registration> regs) {
		this.regs = regs;
	}
	
	
	
	
}
