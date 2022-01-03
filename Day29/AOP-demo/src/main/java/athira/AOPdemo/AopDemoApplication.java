package athira.AOPdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopDemoApplication {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = SpringApplication.run(AopDemoApplication.class, args);
        Student student = context.getBean(Student.class);
        Teacher teacher = context.getBean(Teacher.class);

        student.setStudent(1002, 9840061234L, "Athira", 23, 9.8, "ASIET");
        teacher.setTeacher(2100, 9180440033L, "Radhamani", 49, "Networking", "ASIET");
        System.out.println("###############################################");
        student.welcome();
        System.out.println("###############################################");
        student.displayPersonalDetails();
        System.out.println("###############################################");
        student.displaySchoolDetails();
        System.out.println("###############################################");
        teacher.welcome();
        System.out.println("###############################################");
        teacher.personalDetailsDisplay();
        System.out.println("###############################################");
        teacher.displaySchoolDetails();
        System.out.println("###############################################");
        System.out.println("Student age : " + student.getAge());
        System.out.println("###############################################");
       teacher.setPhoneNumber(0L);
        System.out.println("###############################################");
    }

}
