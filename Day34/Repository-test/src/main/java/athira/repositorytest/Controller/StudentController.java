package athira.repositorytest.Controller;

import athira.repositorytest.Entity.Student;
import athira.repositorytest.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> listAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/new")// localhost:8080/students/new
    public Student addNewStudent(HttpServletRequest request){
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        Integer age=Integer.parseInt(request.getParameter("age"));

        Student student=new Student(name,email,age);
        return studentService.createStudent(student);
    }

    @GetMapping("/students/check/email/{email}")// localhost:8080/students/check/email/khavin@gmail.com
    public Boolean checkIfEmailExists(@PathVariable String email){
        return studentService.checkIfEmailExists(email);
    }




}
