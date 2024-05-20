package tridm.StudentManagement.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "monHoc")
public class MonHoc {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maMH", nullable = false)
	private Long maMH;

	@Column(name = "tenMH", nullable = false)
	private String tenMH;

	@Column(name = "soTChi", nullable = false)
	private int soTC;

	// @ManyToMany(mappedBy = "monHocs")
	// Set<SinhVien> sinhViens;

	public Long getMaMH() {
		return maMH;
	}
	public void setMaMH(Long maMH) {
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
