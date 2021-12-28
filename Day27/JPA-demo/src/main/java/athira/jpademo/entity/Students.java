package athira.jpademo.entity;

import javax.persistence.*;

@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;//not null
    private String batch;

    private Float marks;

    @Column(nullable = false)
    private Integer age;

    @Column(name = "phoneNumber",nullable = false,unique = true,updatable = false)
    private String phoneNumber;//phone_number

    public Students() {}

    public Students( String name, String batch, Float marks, Integer age, String phoneNumber) {
        this.name = name;
        this.batch = batch;
        this.marks = marks;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
   }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Float getMarks() {
        return marks;
    }

    public void setMarks(Float marks) {
        this.marks = marks;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
   public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
