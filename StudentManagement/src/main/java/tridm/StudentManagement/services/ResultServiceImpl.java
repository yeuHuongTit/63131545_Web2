package tridm.StudentManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tridm.StudentManagement.models.Result;
import tridm.StudentManagement.repositories.ResultRepository;

@Service
public class ResultServiceImpl implements ResultService{
    @Autowired ResultRepository resultRepository;
	
	public ResultServiceImpl(ResultRepository resultRepository) {
		super();
		this.resultRepository = resultRepository;
	}

	@Override
	public List<Result> getAllResults() {
		return resultRepository.findAll();
	}

	@Override
	public void saveResult(Result Result) {
		this.resultRepository.save(Result);
	}

	@Override
	public Result getResultById(Long id) {
		Optional<Result> optional = resultRepository.findById(id);
		Result Result = null;
		if (optional.isPresent()) {
			Result = optional.get();
		} else {
			throw new RuntimeException(" Result not found for id :: " + id);
		}
		return Result;
	}

	@Override
	public Result updateResult(Result Result) {
		return resultRepository.save(Result);
	}

	@Override
	public Boolean deleteResultById(Long id) {
		try {
			Result Result = this.getResultById(id);
			if (Result != null) {
				this.resultRepository.delete(Result);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Result> searchResult(String keyword) {
		return this.resultRepository.searchResult(keyword);
	}

	@Override
	public Page<Result> getAllResults(Integer pageNo) {
		Pageable pageable = PageRequest.of(pageNo - 1, 3);
		return this.resultRepository.findAll(pageable);
	}

	@Override
	public Page<Result> searchResult(String keyword, Integer pageNo) {
		List list = this.searchResult(keyword);
		Pageable pageable = PageRequest.of(pageNo - 1, 2);
		Integer start = (int) pageable.getOffset();
		Integer end = (int) (pageable.getOffset() + pageable.getPageSize() > list.size() ? list.size() : pageable.getOffset() + pageable.getPageSize());
		list = list.subList(start,end);
		return new PageImpl<Result>(list, pageable, list.size());
	}
}
