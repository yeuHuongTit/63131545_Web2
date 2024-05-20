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
@Table(name = "ketQua")
public class KetQua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maKQ", nullable = false)
    private Long maKQ;

    @ManyToOne
    @JoinColumn(name = "maMH")
    private MonHoc monHoc;

    @ManyToOne
    @JoinColumn(name = "maSV")
    private SinhVien sinhVien;

    @Column(name = "hocKy", nullable = false)
    private int hocKy;

    @Column(name = "nam", nullable = false)
    private int nam;

    @Column(name = "diem", nullable = false)
    private double diem;
}
