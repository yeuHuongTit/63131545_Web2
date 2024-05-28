package tridm.StudentManagement.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import tridm.StudentManagement.models.Result;

@Service
public interface ResultService {
        List<Result> getAllResults();
	
	// Student saveStudent(Student student);

	void saveResult(Result result);
	
	Result getResultById(Long id);
	
	Result updateResult(Result result);
	
	Boolean deleteResultById(Long id);

	List<Result> searchResult(String keyword);

	Page<Result> getAllResults(Integer pageNo);

	Page<Result> searchResult(String keyword, Integer pageNo);
}
