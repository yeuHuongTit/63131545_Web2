package tridm.StudentManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tridm.StudentManagement.Models.Result;

public interface ResultRepository extends JpaRepository<Result, Long>{
    
}
