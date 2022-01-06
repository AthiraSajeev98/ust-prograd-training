package athira.repositorytest.Repository;

import athira.repositorytest.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student,Long> {
   public Boolean existsByEmail(String email);

   @Query(
           "SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END " +
                   "FROM Student s WHERE s.email = ?1"
   )
   public Boolean checkIfEmailExists(String email);

}
