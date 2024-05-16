package tridm.StudentManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tridm.StudentManagement.models.Khoa;

public interface KhoaRepository extends JpaRepository<Khoa, Long>{
    
}
