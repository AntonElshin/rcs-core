package ru.rcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rcs.entity.SchoolTestText;

@Repository
public interface SchoolTestTextRepository extends JpaRepository<SchoolTestText, String> {

}
