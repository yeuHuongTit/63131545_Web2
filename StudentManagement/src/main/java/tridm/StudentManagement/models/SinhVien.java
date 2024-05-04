package tridm.StudentManagement.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name = "sinhvien")
public class SinhVien {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @Column(name = "mssv", nullable = false)
    private String MSSV;

    @Column(name = "ten", nullable = false)
	private String ten;

    @Column(name = "gioiTinh", nullable = false)
    private String gioiTinh;

    @Column(name = "diaChi", nullable = false)
    private String diaChi;

    @Column(name = "dienThoai", nullable = false)
    private String dienThoai;

    @OneToMany
    @JoinColumn(name = "khoa", nullable = false)
    private Khoa khoa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String mSSV) {
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

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }

}
