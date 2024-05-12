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
@Table(name = "giaoVien")
public class GiaoVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "maGV", nullable = false)
    private String maGV;

    @Column(name = "tenGV", nullable = false)
    private String tenGV;

    @ManyToOne
    @JoinColumn(name = "maKhoa", nullable = false)
    private Khoa maKhoa;

    @ManyToMany
    @JoinTable(name = "khoaHoc", 
        joinColumns = @JoinColumn(name = "maGV"), 
        inverseJoinColumns = @JoinColumn(name = "maMH"))
    Set<MonHoc> monHocs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public Khoa getKhoa() {
        return maKhoa;
    }

    public void setKhoa(Khoa maKhoa) {
        this.maKhoa = maKhoa;
    }

}
