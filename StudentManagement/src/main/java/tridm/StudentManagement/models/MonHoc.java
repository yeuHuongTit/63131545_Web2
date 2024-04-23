package tridm.StudentManagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "monhoc")
public class MonHoc {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
	private String maMH;
	private String tenMH;
	private int soTC;

	
}
