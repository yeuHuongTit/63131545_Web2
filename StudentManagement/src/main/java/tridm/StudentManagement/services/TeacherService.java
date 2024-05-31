package tridm.StudentManagement.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import tridm.StudentManagement.models.Teacher;

@Service
public interface TeacherService {
    List<Teacher> getAllTeachers();
	
	// Student saveStudent(Student student);

	void saveTeacher(Teacher teacher);
	
	Teacher getTeacherById(Long id);
	
	Teacher updateTeacher(Teacher teacher);
	
	Boolean deleteTeacherById(Long id);

	List<Teacher> searchTeacher(String keyword);

	Page<Teacher> getAllTeachers(Integer pageNo);

	Page<Teacher> searchTeacher(String keyword, Integer pageNo);
}
