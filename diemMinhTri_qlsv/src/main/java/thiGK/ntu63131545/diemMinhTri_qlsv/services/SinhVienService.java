package thiGK.ntu63131545.diemMinhTri_qlsv.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import thiGK.ntu63131545.diemMinhTri_qlsv.models.SinhVien;
@Service
public interface SinhVienService {
	public Page<SinhVien> findPaginated(Pageable pageable);
	List<SinhVien> timSinhVienTheoMa(String maSoSV);
	void themSinhVien(SinhVien sinhVien);
	
}