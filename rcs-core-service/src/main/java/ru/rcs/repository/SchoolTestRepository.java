package ru.rcs.repository;

import com.querydsl.core.types.Predicate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ru.rcs.entity.SchoolTest;

@Repository
public interface SchoolTestRepository extends JpaRepository<SchoolTest, String>, QuerydslPredicateExecutor<SchoolTest> {

  List<SchoolTest> findAll(Predicate predicate);

  List<SchoolTest> findAll();

}
