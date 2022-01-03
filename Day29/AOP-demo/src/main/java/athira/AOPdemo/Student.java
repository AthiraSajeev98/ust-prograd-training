package athira.AOPdemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Student {
    private long studentId;
    private long phoneNumber;
    private String name;
    private int age;
    private double totalCgpa;
    private String schoolName;


    Student() {
        System.out.println("Inside Student class");
    }

    public void setPhoneNumber(long phoneNumber) throws IllegalArgumentException {
        if (phoneNumber == 0L) {
            System.out.println("Exception Raised");
            throw new IllegalArgumentException("IllegalArgumentException");
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    public void setStudent(long studentId, long phoneNumber, String name, int age, double totalCgpa, String schoolName) {
        this.studentId = studentId;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.age = age;
        this.totalCgpa = totalCgpa;
        this.schoolName = schoolName;
    }

    public long getStudentId() {
        return studentId;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getTotalCgpa() {
        return totalCgpa;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void welcome() {
        System.out.println("Welcome to Student Class");
//        Teacher.welcome();
    }

    public void displayPersonalDetails() {
        System.out.println("Name : " + getName());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Age : " + getAge());
    }

    public void displaySchoolDetails() {
        System.out.println("Student Name : " + getSchoolName());
        System.out.println("Student ID: " + getStudentId());
        System.out.println("CGPA : " + getTotalCgpa());

    }

}
