package ru.rcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rcs.entity.TaskText;

@Repository
public interface TaskTextRepository extends JpaRepository<TaskText, String> {

}
