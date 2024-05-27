package tridm.StudentManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tridm.StudentManagement.models.Result;

public interface ResultRepository extends JpaRepository<Result, Long>{
    
}
