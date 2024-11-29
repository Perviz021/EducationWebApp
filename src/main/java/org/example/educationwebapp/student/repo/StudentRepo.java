package org.example.educationwebapp.student.repo;


import org.example.educationwebapp.common.CommonRepo;
import org.example.educationwebapp.common.MyDatabase;
import org.example.educationwebapp.student.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements CommonRepo<Student> {
    @Override
    public List<Student> getList() {
        List<Student> result = new ArrayList<>();
        try (Connection connection = MyDatabase.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("select * from student");
            getStudent(result, resultset);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public void update(Student obj) {
        try (Connection connection = MyDatabase.connect()) {
            PreparedStatement stmt = connection.prepareStatement("update student set name=?, surname=?, age=?, email=?, university=? where id=?");
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getSurname());
            stmt.setInt(3, obj.getAge());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getUniversity());
            stmt.setInt(6, obj.getId());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Student obj) {
        try (Connection connection = MyDatabase.connect()) {
            PreparedStatement stmt = connection.prepareStatement("insert into student (name, surname, age, email, university) values(?,?,?,?,?)");
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getSurname());
            stmt.setInt(3, obj.getAge());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getUniversity());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = MyDatabase.connect()) {
            PreparedStatement stmt = connection.prepareStatement("delete from student where id=?");
            stmt.setInt(1, id);

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student findById(int id) {
        try (Connection connection = MyDatabase.connect()) {
            PreparedStatement stmt = connection.prepareStatement("select * from student where id=?");
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setAge(resultSet.getInt("age"));
                student.setEmail(resultSet.getString("email"));
                student.setUniversity(resultSet.getString("university"));
                student.setPassword(resultSet.getString("password"));
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> getList(String name, String surname, Integer age, String email, String university, String password) {
        List<Student> result = new ArrayList<>();
        String query = "select * from student where 1=1 ";
        int index = 0;
        if (name != null && !name.trim().isEmpty()) {
            query += " and name=?";
            index++;
        }
        if (surname != null && !surname.trim().isEmpty()) {
            query += " and surname=?";
            index++;
        }
        if (age != null && age > 0) {
            query += " and age=?";
            index++;
        }
        if (email != null && !email.trim().isEmpty()) {
            query += " and email=?";
            index++;
        }
        if (university != null && !university.trim().isEmpty()) {
            query += " and university=?";
            index++;
        }
        if (password != null && !password.trim().isEmpty()) {
            query += " and password=?";
            index++;
        }

        try (Connection connection = MyDatabase.connect()) {
            PreparedStatement stmt = connection.prepareStatement(query);
            if (password != null && !password.trim().isEmpty()) {
                stmt.setString(index--, password);
            }
            if (university != null && !university.trim().isEmpty()) {
                stmt.setString(index--, university);
            }
            if (email != null && !email.trim().isEmpty()) {
                stmt.setString(index--, email);
            }
            if (age != null && age > 0) {
                stmt.setInt(index--, age);
            }
            if (surname != null && !surname.trim().isEmpty()) {
                stmt.setString(index--, surname);
            }
            if (name != null && !name.trim().isEmpty()) {
                stmt.setString(index, name);
            }

            ResultSet resultSet = stmt.executeQuery();
            getStudent(result, resultSet);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private void getStudent(List<Student> result, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setSurname(resultSet.getString("surname"));
            student.setAge(resultSet.getInt("age"));
            student.setEmail(resultSet.getString("email"));
            student.setUniversity(resultSet.getString("university"));
            student.setPassword(resultSet.getString("password"));
            result.add(student);
        }
    }
}
