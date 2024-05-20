package tridm.StudentManagement.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "sinhVien")
public class SinhVien {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mssv", nullable = false)
	private Long MSSV;

    @Column(name = "ten", nullable = false)
	private String ten;

    @Column(name = "gioiTinh", nullable = false)
    private String gioiTinh;

    @Column(name = "diaChi", nullable = false)
    private String diaChi;

    @Column(name = "dienThoai", nullable = false)
    private String dienThoai;

    @ManyToOne
    @JoinColumn(name = "maKhoa", nullable = false)
    private Khoa maKhoa;

    // @ManyToMany
    // @JoinTable(name = "ketQua", 
    //     joinColumns = @JoinColumn(name = "mssv"), 
    //     inverseJoinColumns = @JoinColumn(name = "maMH"))
    // Set<MonHoc> monHocs;

    public Long getMSSV() {
        return MSSV;
    }

    public void setMSSV(Long mSSV) {
        MSSV = mSSV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public Khoa getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(Khoa maKhoa) {
        this.maKhoa = maKhoa;
    }

    

}
