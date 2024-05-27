package tridm.StudentManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tridm.StudentManagement.models.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{
    
}
