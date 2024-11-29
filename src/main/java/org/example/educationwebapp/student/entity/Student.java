package org.example.educationwebapp.student.entity;


import org.example.educationwebapp.common.Person;

public class Student extends Person {
    private String university;

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
