package tridm.StudentManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tridm.StudentManagement.Models.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{
    
}
