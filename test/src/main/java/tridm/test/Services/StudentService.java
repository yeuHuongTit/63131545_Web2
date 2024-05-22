package tridm.test.Services;

import java.util.List;

import org.springframework.data.domain.Page;

import tridm.test.Models.Student;

public interface StudentService {
	List<Student> getAllStudents();
	
	// Student saveStudent(Student student);

	void saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);

	Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}