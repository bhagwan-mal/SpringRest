package in.nit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="student_tab")
public class Student {
	@Id
	@GeneratedValue
	private Integer Id;
	
	private String stdName;
	private String stdEmail;
	private Double stdFee;
	private String stdCourse;
	private String stdAddrs;

}
