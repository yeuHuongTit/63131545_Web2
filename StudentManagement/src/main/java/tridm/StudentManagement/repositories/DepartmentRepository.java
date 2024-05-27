package tridm.StudentManagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tridm.StudentManagement.models.*;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
    @Query("SELECT s FROM Department s WHERE s.name LIKE %?1%")
    List<Department> searchDepartment(String keyword);
}
