package tridm.StudentManagement.services;

import java.util.List;

import tridm.StudentManagement.models.SinhVien;

public interface SinhVienService {    
    List<SinhVien> getAllSinhVien();

    SinhVien saveSinhVien(SinhVien mssv);

    SinhVien getSinhVienById(Long id);

    SinhVien updateSinhVien(SinhVien mssv);

    void deleteSinhVien(Long id);
}
