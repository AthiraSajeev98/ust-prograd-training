package athira.jpademo.repository;

import athira.jpademo.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

//Controller-------Service--------Repository------------->Database
public interface StudentRepository extends JpaRepository<Students,Long> {

}
