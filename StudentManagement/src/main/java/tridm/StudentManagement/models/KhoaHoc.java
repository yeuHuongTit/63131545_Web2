package tridm.StudentManagement.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
// @Table(name = "khoaHoc")
public class KhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "maKH", nullable = false)
    private String maKH;

    @Column(name = "hocKy", nullable = false)
    private int hocKy;

    @Column(name = "nam", nullable = false)
    private int nam;

    @ManyToOne
    @JoinColumn(name = "maGV", nullable = false)
    private GiaoVien maGV;

    @ManyToOne
    @JoinColumn(name = "maMH", nullable = false)
    private MonHoc maMH;

    @ManyToMany
    @JoinTable(name = "ketQua", 
        joinColumns = @JoinColumn(name = "maKH"), 
        inverseJoinColumns = @JoinColumn(name = "maSV"))
    Set<SinhVien> sinhViens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public GiaoVien getMaGV() {
        return maGV;
    }

    public void setMaGV(GiaoVien maGV) {
        this.maGV = maGV;
    }

    public MonHoc getMaMH() {
        return maMH;
    }

    public void setMaMH(MonHoc maMH) {
        this.maMH = maMH;
    }

    
}
