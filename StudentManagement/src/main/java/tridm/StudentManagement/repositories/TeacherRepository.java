package tridm.StudentManagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tridm.StudentManagement.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    @Query("SELECT s FROM Teacher s WHERE s.name LIKE %?1%")
    List<Teacher> searchTeacher(String keyword);
}
