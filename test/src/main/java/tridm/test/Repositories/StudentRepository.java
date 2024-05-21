package tridm.test.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tridm.test.Models.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}