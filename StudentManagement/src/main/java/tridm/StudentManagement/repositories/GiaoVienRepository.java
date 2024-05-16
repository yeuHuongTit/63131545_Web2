package tridm.StudentManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tridm.StudentManagement.models.GiaoVien;

public interface GiaoVienRepository extends JpaRepository<GiaoVien, Long>{
    
}
