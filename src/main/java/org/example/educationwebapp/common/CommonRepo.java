package org.example.educationwebapp.common;

import org.example.educationwebapp.student.entity.Student;

import java.util.List;

public interface CommonRepo<T> {
    public List<T> getList();

    public void update(T obj);

    public void insert(T obj);

    public void delete(Integer id);

    public T findById(int id);

    public List<T> getList(String name, String surname, Integer age, String email, String university, String password);

}
