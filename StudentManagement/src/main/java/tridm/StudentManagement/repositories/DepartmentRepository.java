package tridm.StudentManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tridm.StudentManagement.Models.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
    
}
