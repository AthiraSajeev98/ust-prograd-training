package athira.jpademo.service;

import athira.jpademo.entity.Students;
import athira.jpademo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Students saveStudent(Students students){
        //validation,error
        return studentRepository.save(students);
    }
    public List<Students> listAll(){
        return studentRepository.findAll();
    }
}
