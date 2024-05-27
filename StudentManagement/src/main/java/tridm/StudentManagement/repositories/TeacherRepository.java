package tridm.StudentManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tridm.StudentManagement.Models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    
}
