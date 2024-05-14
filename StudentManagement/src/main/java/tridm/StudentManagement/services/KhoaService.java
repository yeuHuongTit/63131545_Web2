package tridm.StudentManagement.services;

import java.util.List;

import tridm.StudentManagement.models.Khoa;

public interface KhoaService {
    List<Khoa> getAllKhoa();

    Khoa saveKhoa(Khoa khoa);

    Khoa getKhoaById(Long id);

    Khoa updateKhoa(Khoa khoa);

    void deleteKhoa(Long id);
}
