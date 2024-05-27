package tridm.StudentManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tridm.StudentManagement.models.Subject;
import tridm.StudentManagement.repositories.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService{
    @Autowired SubjectRepository subjectRepository;
	
	public SubjectServiceImpl(SubjectRepository subjectRepository) {
		super();
		this.subjectRepository = subjectRepository;
	}

	@Override
	public List<Subject> getAllSubjects() {
		return subjectRepository.findAll();
	}

	@Override
	public void saveSubject(Subject Subject) {
		this.subjectRepository.save(Subject);
	}

	@Override
	public Subject getSubjectById(Long id) {
		Optional<Subject> optional = subjectRepository.findById(id);
		Subject Subject = null;
		if (optional.isPresent()) {
			Subject = optional.get();
		} else {
			throw new RuntimeException(" Subject not found for id :: " + id);
		}
		return Subject;
	}

	@Override
	public Subject updateSubject(Subject Subject) {
		return subjectRepository.save(Subject);
	}

	@Override
	public Boolean deleteSubjectById(Long id) {
		try {
			Subject Subject = this.getSubjectById(id);
			if (Subject != null) {
				this.subjectRepository.delete(Subject);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Subject> searchSubject(String keyword) {
		return this.subjectRepository.searchSubject(keyword);
	}

	@Override
	public Page<Subject> getAllSubjects(Integer pageNo) {
		Pageable pageable = PageRequest.of(pageNo - 1, 3);
		return this.subjectRepository.findAll(pageable);
	}

	@Override
	public Page<Subject> searchSubject(String keyword, Integer pageNo) {
		List list = this.searchSubject(keyword);
		Pageable pageable = PageRequest.of(pageNo - 1, 2);
		Integer start = (int) pageable.getOffset();
		Integer end = (int) (pageable.getOffset() + pageable.getPageSize() > list.size() ? list.size() : pageable.getOffset() + pageable.getPageSize());
		list = list.subList(start,end);
		return new PageImpl<Subject>(list, pageable, list.size());
	}
}
