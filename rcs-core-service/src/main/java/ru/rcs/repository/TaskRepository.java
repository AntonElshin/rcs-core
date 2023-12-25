package ru.rcs.repository;

import com.querydsl.core.types.Predicate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ru.rcs.entity.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, String>, QuerydslPredicateExecutor<Task> {

    List<Task> findAll(Predicate predicate);
}
