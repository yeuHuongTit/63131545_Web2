package tridm.StudentManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tridm.StudentManagement.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    
}
