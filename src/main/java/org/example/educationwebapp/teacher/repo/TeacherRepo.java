package org.example.educationwebapp.teacher.repo;


import org.example.educationwebapp.common.CommonRepo;
import org.example.educationwebapp.common.MyDatabase;
import org.example.educationwebapp.teacher.entity.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepo implements CommonRepo<Teacher> {
    @Override
    public List<Teacher> getList() {
        List<Teacher> result = new ArrayList<>();
        try (Connection connection = MyDatabase.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("select * from teacher");
            getTeacher(result, resultset);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public void update(Teacher obj) {
        try (Connection connection = MyDatabase.connect()) {
            PreparedStatement stmt = connection.prepareStatement("update teacher set name=?, surname=?, age=?, email=?, salary=? where id=?");
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getSurname());
            stmt.setInt(3, obj.getAge());
            stmt.setString(4, obj.getEmail());
            stmt.setDouble(5, obj.getSalary());
            stmt.setInt(6, obj.getId());

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Teacher obj) {
        try (Connection connection = MyDatabase.connect()) {
            PreparedStatement stmt = connection.prepareStatement("insert into teacher values(?,?,?,?,?)");
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getSurname());
            stmt.setInt(3, obj.getAge());
            stmt.setString(4, obj.getEmail());
            stmt.setDouble(5, obj.getSalary());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = MyDatabase.connect()) {
            PreparedStatement stmt = connection.prepareStatement("delete from teacher where id=?");
            stmt.setInt(1, id);

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Teacher findById(int id) {
        try (Connection connection = MyDatabase.connect()) {
            PreparedStatement stmt = connection.prepareStatement("select * from teacher where id=?");
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt("id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setSurname(resultSet.getString("surname"));
                teacher.setAge(resultSet.getInt("age"));
                teacher.setEmail(resultSet.getString("email"));
                teacher.setSalary(resultSet.getDouble("salary"));
                return teacher;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Teacher> getList(String name, String surname, Integer age, String email, String university, String password) {
//        List<Teacher> result = new ArrayList<>();
//        try (Connection connection = MyDatabase.connect()) {
//            PreparedStatement stmt = connection.prepareStatement("select * from teacher where name=? or surname=?");
//            stmt.setString(1, name);
//            stmt.setString(2, surname);
//            ResultSet resultSet = stmt.executeQuery();
//            getTeacher(result, resultSet);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return result;
        return null;
    }

    private void getTeacher(List<Teacher> result, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Teacher teacher = new Teacher();
            teacher.setId(resultSet.getInt("id"));
            teacher.setName(resultSet.getString("name"));
            teacher.setSurname(resultSet.getString("surname"));
            teacher.setAge(resultSet.getInt("age"));
            teacher.setEmail(resultSet.getString("email"));
            teacher.setSalary(resultSet.getDouble("salary"));
            result.add(teacher);
        }
    }
}
