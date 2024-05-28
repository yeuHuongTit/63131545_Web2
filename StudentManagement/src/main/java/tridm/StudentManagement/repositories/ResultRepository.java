package tridm.StudentManagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tridm.StudentManagement.models.Result;

public interface ResultRepository extends JpaRepository<Result, Long>{
    @Query("SELECT s FROM Result s WHERE str(s.term) LIKE %?1%")
    // @Query("SELECT * FROM Result")

    List<Result> searchResult(String keyword);
}
