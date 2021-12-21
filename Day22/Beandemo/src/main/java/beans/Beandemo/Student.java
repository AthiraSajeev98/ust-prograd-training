package beans.Beandemo;

import org.springframework.stereotype.Component;

@Component
public class Student {
    public String studentName="Athira Sajeev";
    public int mark=90;

    Student(){
        System.out.println("Student object created");
    }

//    public void setStudentName(String studentName){
//        this.studentName=studentName;
//    }

    public void getStudentName(){
        System.out.println("student Name : "+studentName);
    }

    //    public void setAge(int age){
//        this.age=age;
//    }
    public void getmark(){
        System.out.println("Mark : "+mark);
    }
}
