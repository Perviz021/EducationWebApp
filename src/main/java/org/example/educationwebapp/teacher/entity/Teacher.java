package org.example.educationwebapp.teacher.entity;


import org.example.educationwebapp.common.Person;

public class Teacher extends Person {
    private Double salary;
    public Person person;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
