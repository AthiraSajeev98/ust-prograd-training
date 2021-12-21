package beans.Beandemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class School {
    public String schoolName = "ASIET";
    public String schoolId = "ASIET@123";

    School() {
        System.out.println("School object created");
    }

    @Autowired
    public Student student;

    public void display() {
        System.out.println("School Name : " + schoolName);
        System.out.println("School ID : " + schoolId);
        student.getStudentName();
        student.getmark();

    }
}
