package tridm.StudentManagement.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tridm.StudentManagement.models.SinhVien;
import tridm.StudentManagement.repositories.SinhVienRepository;

@Service
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
    public SinhVien getSinhVienById(Long mssv) {
        return svRepository.findById(mssv).get();
    }

    @Override
    public SinhVien updateSinhVien(SinhVien sv) {
        return svRepository.save(sv);
    }

    @Override
    public void deleteSinhVien(Long mssv) {
        svRepository.deleteById(mssv);
    }
    
}
