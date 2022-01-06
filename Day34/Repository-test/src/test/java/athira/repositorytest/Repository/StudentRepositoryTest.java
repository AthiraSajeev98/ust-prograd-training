package athira.repositorytest.Repository;

import athira.repositorytest.Entity.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    public StudentRepository studentRepository;

    @Nested
    class checkIfEmailExists{

        @BeforeEach
        public void setup(){
            Student Adhav=new Student("Adhav","adhav@gmail.com",3);
//            Student Madhav=new Student("Madhav","madhav@gmail.com",3);
            studentRepository.save(Adhav);
        }

        @AfterEach
        public  void deleteAll(){
            studentRepository.deleteAll();
        }

        @Test
        public void checkIfEmailExistsInStudentRepository(){
            boolean actualValue=studentRepository.checkIfEmailExists("adhav@gmail.com");
            assertTrue(actualValue);
        }

        @Test
        public void checkIfEmailDoesNotExistsInStudentRepository(){
            boolean actualValue=studentRepository.checkIfEmailExists("madhav@gmail.com");
//            assertFalse(actualValue);
            assertEquals(false,actualValue);
        }

    }

}