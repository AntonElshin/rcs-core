package ru.rcs.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rcs.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {

  @Query("select sc from Subject sc where "
      + "lower(sc.name) like concat('%', upper(:search), '%') "
      + "or lower(sc.systemName) like concat('%', upper(:search), '%')")
  List<Subject> find(String search);

  List<Subject> findAll();

}
