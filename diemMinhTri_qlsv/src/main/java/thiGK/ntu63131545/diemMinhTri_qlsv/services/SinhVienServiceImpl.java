package thiGK.ntu63131545.diemMinhTri_qlsv.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import thiGK.ntu63131545.diemMinhTri_qlsv.models.SinhVien;

@Service
public class SinhVienServiceImpl implements SinhVienService {
	// Ta hard-code dữ liệu tại đây  để tiện demo------ 
	static List<SinhVien> dsSinhVien=  new ArrayList<SinhVien>();
	static {
					dsSinhVien.add(new SinhVien("0001", "Trần Văn A"));
					dsSinhVien.add(new SinhVien("0002", "Trần Văn Long"));
					dsSinhVien.add(new SinhVien("0003", "Nguyễn Thị Bo"));
					dsSinhVien.add(new SinhVien("0004", "Phạm Văn Cường"));
					dsSinhVien.add(new SinhVien("0005", "Lê Thị Dương"));
					dsSinhVien.add(new SinhVien("0006", "Hoàng Minh Đức"));
					dsSinhVien.add(new SinhVien("0007", "Vũ Thị Mai"));
					dsSinhVien.add(new SinhVien("0008", "Nguyễn Văn Hùng"));
					dsSinhVien.add(new SinhVien("0009", "Trần Thị Huệ"));
					dsSinhVien.add(new SinhVien("0010", "Lê Văn Nam"));

	}
	//----------hết phần hard-code dữ liệu ---------------------
	@Override
	public Page<SinhVien> findPaginated(Pageable pageable) {
		int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<SinhVien> list;

        if (dsSinhVien.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, dsSinhVien.size());
            list = dsSinhVien.subList(startItem, toIndex);
        }
        Page<SinhVien> sinhvienPage = new PageImpl<SinhVien>(list, PageRequest.of(currentPage, pageSize), dsSinhVien.size());
        return sinhvienPage;
	}

}