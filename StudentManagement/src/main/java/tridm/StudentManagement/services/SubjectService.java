package tridm.StudentManagement.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import tridm.StudentManagement.models.*;

@Service
public interface SubjectService {
    List<Subject> getAllSubjects();
	
	// Subject saveSubject(Subject Subject);

	void saveSubject(Subject subject);
	
	Subject getSubjectById(Long id);
	
	Subject updateSubject(Subject subject);
	
	Boolean deleteSubjectById(Long id);

	List<Subject> searchSubject(String keyword);

	Page<Subject> getAllSubjects(Integer pageNo);

	Page<Subject> searchSubject(String keyword, Integer pageNo);
}
