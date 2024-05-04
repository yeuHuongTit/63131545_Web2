package tridm.StudentManagement.models;

import jakarta.persistence.Column;
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

	@Column(name = "maMH", nullable = false)
	private String maMH;

	@Column(name = "tenMH", nullable = false)
	private String tenMH;

	@Column(name = "soTC", nullable = false)
	private int soTC;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public int getSoTC() {
		return soTC;
	}
	public void setSoTC(int soTC) {
		this.soTC = soTC;
	}
	

	
}
