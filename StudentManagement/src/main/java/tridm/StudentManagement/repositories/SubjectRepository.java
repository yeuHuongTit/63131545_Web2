package tridm.StudentManagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tridm.StudentManagement.models.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{
    @Query("SELECT s FROM Subject s WHERE s.name LIKE %?1%")
    List<Subject> searchSubject(String keyword);
}
