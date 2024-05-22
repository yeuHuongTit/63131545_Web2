package tridm.StudentManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tridm.StudentManagement.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
    
}
