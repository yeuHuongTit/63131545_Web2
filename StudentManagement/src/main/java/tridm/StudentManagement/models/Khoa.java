package tridm.StudentManagement.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "khoa")
public class Khoa {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    private String maKhoa;
	private String tenKhoa;
}
