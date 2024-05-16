package tridm.StudentManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tridm.StudentManagement.models.MonHoc;

public interface MonHocRepository extends JpaRepository<MonHoc, Long>{
    
}
