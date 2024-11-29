package org.example.educationwebapp;

import org.example.educationwebapp.student.entity.Student;
import org.example.educationwebapp.student.repo.StudentRepo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Jack");
        student.setSurname("Smith");
        student.setEmail("jsmith@gmail.com");
        student.setAge(28);
        student.setUniversity("Harvard");

        StudentRepo studentRepo = new StudentRepo();
        studentRepo.insert(student);

        List<Student> students = studentRepo.getList();
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
