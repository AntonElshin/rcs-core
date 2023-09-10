package ru.rcs.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rcs.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {

  @Query("select s from Subject s where "
      + "lower(s.name) like %:search% "
      + "or lower(s.systemName) like %:search%")
  List<Subject> find(String search);

  List<Subject> findAll();

}
