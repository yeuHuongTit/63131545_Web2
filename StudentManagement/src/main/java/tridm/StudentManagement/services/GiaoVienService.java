package tridm.StudentManagement.services;


import java.util.List;

import tridm.StudentManagement.models.GiaoVien;

public interface GiaoVienService {
    List<GiaoVien> getAllGiaoVien();

    GiaoVien saveGiaoVien(GiaoVien gv);

    GiaoVien getGiaoVienById(Long id);

    GiaoVien updateGiaoVien(GiaoVien gv);

    void deleteGiaoVien(Long id);
}
