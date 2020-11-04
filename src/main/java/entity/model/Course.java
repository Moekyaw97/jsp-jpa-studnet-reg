package entity.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.CascadeType.REMOVE;

@Entity
@NamedQuery(name = "Course.getAll", query = "SELECT c FROM Course c")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private int id;
	private String name;
	private int fees;
	private String duration;
	private String level;

	
	 @OneToMany(mappedBy = "course", cascade = REMOVE) 
	 private List<Class> classes;
	 
	 

	public Course() {
		super();
	}
	

	public List<Class> getClasses() {
		return classes;
	}


	public void setClasses(List<Class> classes) {
		this.classes = classes;
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

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
