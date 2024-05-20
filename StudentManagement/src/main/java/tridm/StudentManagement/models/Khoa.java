package tridm.StudentManagement.models;
import jakarta.persistence.Column;
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
	@Column(name = "maKhoa", nullable = false)
	private Long maKhoa;

	@Column(name = "tenKhoa", nullable = false)
	private String tenKhoa;

	public Long getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(Long maKhoa) {
		this.maKhoa = maKhoa;
	}
	public String getTenKhoa() {
		return tenKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}
	
}
