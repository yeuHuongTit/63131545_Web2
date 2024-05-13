package tridm.StudentManagement.services;

import java.util.List;

import tridm.StudentManagement.models.SinhVien;
import tridm.StudentManagement.repositories.SinhVienRepository;

public class SinhVienServiceImpl implements SinhVienService{
    private SinhVienRepository svRepository;

    public SinhVienServiceImpl(SinhVienRepository svRepository) {
        super();
        this.svRepository = svRepository;
    }

    @Override
    public List<SinhVien> getAllSinhVien() {
        return svRepository.findAll();
    }

    @Override
    public SinhVien saveSinhVien(SinhVien sv) {
        return svRepository.save(sv);
    }

    @Override
    public SinhVien getSinhVienById(Long id) {
        return svRepository.findById(id).get();
    }

    @Override
    public SinhVien updateSinhVien(SinhVien sv) {
        return svRepository.save(sv);
    }

    @Override
    public void deleteSinhVien(Long id) {
        svRepository.deleteById(id);
    }
    
}
