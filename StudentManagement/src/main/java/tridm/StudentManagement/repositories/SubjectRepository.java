package tridm.StudentManagement.repositories;

import tridm.StudentManagement.models.Subject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long>{
    
}
