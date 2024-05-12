package tridm.StudentManagement.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
// @Table(name = "ketQua")
public class KetQua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "maKH")
    private KhoaHoc khoaHoc;

    @ManyToOne
    @JoinColumn(name = "maSV")
    private SinhVien sinhVien;

    @Column(name = "diem", nullable = false)
    private double diem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    
}
