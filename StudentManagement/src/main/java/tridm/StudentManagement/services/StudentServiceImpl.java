package tridm.StudentManagement.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import tridm.StudentManagement.Models.Student;
import tridm.StudentManagement.Repositories.StudentRepository;

import org.springframework.data.domain.Pageable;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public void saveStudent(Student student) {
		this.studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		Optional<Student> optional = studentRepository.findById(id);
		Student student = null;
		if (optional.isPresent()) {
			student = optional.get();
		} else {
			throw new RuntimeException(" Student not found for id :: " + id);
		}
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Boolean deleteStudentById(Long id) {
		try {
			Student student = this.getStudentById(id);
			if (student != null) {
				this.studentRepository.delete(student);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Student> searchStudent(String keyword) {
		return this.studentRepository.searchStudent(keyword);
	}

	@Override
	public Page<Student> getAllStudents(Integer pageNo) {
		Pageable pageable = PageRequest.of(pageNo - 1, 3);
		return this.studentRepository.findAll(pageable);
	}

	@Override
	public Page<Student> searchStudent(String keyword, Integer pageNo) {
		List list = this.searchStudent(keyword);
		Pageable pageable = PageRequest.of(pageNo - 1, 2);
		Integer start = (int) pageable.getOffset();
		Integer end = (int) (pageable.getOffset() + pageable.getPageSize() > list.size() ? list.size() : pageable.getOffset() + pageable.getPageSize());
		list = list.subList(start,end);
		return new PageImpl<Student>(list, pageable, list.size());
	}


}