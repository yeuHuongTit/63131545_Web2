package tridm.StudentManagement.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import tridm.StudentManagement.models.Teacher;
import tridm.StudentManagement.repositories.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired TeacherRepository teacherRepository;
	
	public TeacherServiceImpl(TeacherRepository teacherRepository) {
		super();
		this.teacherRepository = teacherRepository;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}

	@Override
	public void saveTeacher(Teacher teacher) {
		this.teacherRepository.save(teacher);
	}

	@Override
	public Teacher getTeacherById(Long id) {
		Optional<Teacher> optional = teacherRepository.findById(id);
		Teacher Teacher = null;
		if (optional.isPresent()) {
			Teacher = optional.get();
		} else {
			throw new RuntimeException(" Teacher not found for id :: " + id);
		}
		return Teacher;
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public Boolean deleteTeacherById(Long id) {
		try {
			Teacher teacher = this.getTeacherById(id);
			if (teacher != null) {
				this.teacherRepository.delete(teacher);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Teacher> searchTeacher(String keyword) {
		return this.teacherRepository.searchTeacher(keyword);
	}

	@Override
	public Page<Teacher> getAllTeachers(Integer pageNo) {
		Pageable pageable = PageRequest.of(pageNo - 1, 3);
		return this.teacherRepository.findAll(pageable);
	}

	@Override
	public Page<Teacher> searchTeacher(String keyword, Integer pageNo) {
		List list = this.searchTeacher(keyword);
		Pageable pageable = PageRequest.of(pageNo - 1, 2);
		Integer start = (int) pageable.getOffset();
		Integer end = (int) (pageable.getOffset() + pageable.getPageSize() > list.size() ? list.size() : pageable.getOffset() + pageable.getPageSize());
		list = list.subList(start,end);
		return new PageImpl<Teacher>(list, pageable, list.size());
	}
}
