package athira.repositorytest.Service;

import athira.repositorytest.Entity.Student;
import athira.repositorytest.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long Id){
        return studentRepository.getById(Id);
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Boolean checkIfEmailExists(String email){
        return studentRepository.existsByEmail(email);
    }

}
