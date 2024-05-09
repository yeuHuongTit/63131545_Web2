package tridm.StudentManagement.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "giangDay")
public class GiangDay {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @Column(name = "maKhoaHoc", nullable = false)
	private String maKhoaHoc;

    // @ManyToOne(name = )

    @Column(name = "hocKy", nullable = false)
	private int hocKy;

    @Column(name = "nam", nullable = false)
	private int maMH;
}
