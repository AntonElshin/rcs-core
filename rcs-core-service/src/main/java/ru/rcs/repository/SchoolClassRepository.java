package ru.rcs.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rcs.entity.SchoolClass;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, String> {

  @Query("select sc from SchoolClass sc where "
       + "lower(sc.name) like %:search% "
       + "or lower(sc.systemName) like %:search%")
  List<SchoolClass> find(String search);

  List<SchoolClass> findAll();

}
