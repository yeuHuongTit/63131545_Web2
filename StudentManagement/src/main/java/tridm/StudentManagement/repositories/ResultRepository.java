package tridm.StudentManagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tridm.StudentManagement.models.Result;

public interface ResultRepository extends JpaRepository<Result, Long>{
    // @Query("SELECT s FROM Result s WHERE str(s.term) LIKE %?1%")
    // @Query("SELECT r FROM Result r join Student s on r.studentId = s.studentId WHERE s.name like %?1%")
    @Query("SELECT r FROM Result r JOIN r.studentId s WHERE s.name LIKE %:name%")

    List<Result> searchResult(@Param("name") String keyword);
}
