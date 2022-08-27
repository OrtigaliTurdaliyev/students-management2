package uz.pdp.studentsmanagement.students;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public static String url = "jdbc:postgresql://localhost:5432/student-management-db";
    public static String dbUser = "postgres";
    public static String dbPassword = "1";

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, dbUser, dbPassword);
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static int addStudent(Student student) {
        int nameInt = 0;
        Connection connection = getConnection();
        try(PreparedStatement preparedStatement=connection.prepareStatement("insert into student(first_name, last_name,email,course) values(?,?,?,?);")) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setInt(4, student.getCourse());
            nameInt=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nameInt;

    }


    public static List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        Connection connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from student")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = Student.builder()
                        .id(resultSet.getInt(1))
                        .firstName(resultSet.getString(2))
                        .lastName(resultSet.getString(3))
                        .email(resultSet.getString(4))
                        .course(resultSet.getInt(5))
                        .build();
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public static boolean deleteStudent(int id) {
        int status = 0;
        Connection connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from  student where id=?")) {
            preparedStatement.setInt(1, id);
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status > 0;

    }

    public static int updateStudent(Student student) {
        int status = 0;
        Connection connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("update student set first_name=?,last_name=?,email=?,course=? where id=?;")) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setInt(4, student.getCourse());
            preparedStatement.setInt(5, student.getId());
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static Student getStudentById(int id) {
        Student student = new Student();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student where id=? ");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student.setId(resultSet.getInt(1));
                student.setFirstName(resultSet.getString(2));
                student.setLastName(resultSet.getString(3));
                student.setEmail(resultSet.getString(4));
                student.setCourse(resultSet.getInt(5));
            }
            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return student;
    }








}



