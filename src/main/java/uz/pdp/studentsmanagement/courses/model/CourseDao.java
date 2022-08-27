package uz.pdp.studentsmanagement.courses.model;

import uz.pdp.studentsmanagement.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {

    public static List<Course> getAllCoursesForSelect() {

        try (Connection connection = DbConnection.getConnection()) {
            String sql = "select  c.id, c.name from course c";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Course> courseList = new ArrayList<>();
            while (resultSet.next()) {
                courseList.add(
                        Course.builder()
                                .id(resultSet.getInt(1))
                                .name(resultSet.getString(2))
                                .build()
                );
            }
            return courseList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
