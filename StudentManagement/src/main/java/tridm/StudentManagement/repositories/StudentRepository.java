package tridm.StudentManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tridm.StudentManagement.models.Student;;

public interface StudentRepository extends JpaRepository<Student, Long>{

}