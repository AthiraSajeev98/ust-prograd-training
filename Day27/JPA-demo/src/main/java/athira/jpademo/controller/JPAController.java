package athira.jpademo.controller;

import athira.jpademo.entity.Students;
import athira.jpademo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class JPAController {
    @Autowired
    private StudentService service;
    @RequestMapping("/")
    public  String index(){
        Students student1=new Students("Athira Sajeev","IT",98f,23,"9845674321");
        service.saveStudent(student1);
        return "student saved";
    }

    @RequestMapping("/list")
    public List<Students> list(){
       return service.listAll();
    }

    @RequestMapping(value="/create")
    public Students create(HttpServletRequest request){
        String name=request.getParameter("name");
        String phoneNumber=request.getParameter("phone");
        Students student1=new Students(name,"IT",98f,23,phoneNumber);

        return service.saveStudent(student1);
    }
}
