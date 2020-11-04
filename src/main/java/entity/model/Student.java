package entity.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.CascadeType.REMOVE;




@Entity
@NamedQuery(name="Student.getAll",query="SELECT s FROM Student s")
public class Student implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stu_id")
	private int id;
	private String name;
	private String email;
	private String phone;

	@OneToMany(mappedBy = "student", cascade = REMOVE)
	private List<Registration> regs;
	
	
	
	public List<Registration> getRegs() {
		return regs;
	}

	public void setRegs(List<Registration> regs) {
		this.regs = regs;
	}

	public Student() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	
   
	
}
