package athira.AOPdemo;

import org.springframework.stereotype.Component;

@Component
public class Teacher {
    private long teacherId;
    private long phoneNumber;
    private String name;
    private int age;
    private String subject;
    private String schoolName;


    Teacher() {
        System.out.println("Inside Teacher class");
    }

    public void setPhoneNumber(long phoneNumber) throws IllegalArgumentException {
        if (phoneNumber == 0L) {
            System.out.println("Exception Raised");
            throw new IllegalArgumentException("IllegalArgumentException");
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    public void setTeacher(long teacherId, long phoneNumber, String name, int age, String subject, String schoolName) {
        this.teacherId = teacherId;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.schoolName = schoolName;
    }

    public long getTeacherId() {
        return teacherId;
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

    public String getSubject() {
        return subject;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void welcome() {
        System.out.println("Welcome to Teacher Class");
    }

    public void personalDetailsDisplay() {
        System.out.println("Name : " + getName());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Age : " + getAge());
    }

    public void displaySchoolDetails() {
        System.out.println("Student Name : " + getSchoolName());
        System.out.println("Teacher ID: " + getTeacherId());
        System.out.println("Subject : " + getSubject());
    }


}
