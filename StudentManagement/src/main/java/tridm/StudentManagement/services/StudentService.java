package tridm.StudentManagement.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import tridm.StudentManagement.models.Student;

@Service
public interface StudentService {
	List<Student> getAllStudents();
	
	// Student saveStudent(Student student);

	void saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	Boolean deleteStudentById(Long id);

	List<Student> searchStudent(String keyword);

	Page<Student> getAllStudents(Integer pageNo);

	Page<Student> searchStudent(String keyword, Integer pageNo);

}