package idproject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IDCardCRUD {

    public static void createStudent(String idNumber, String lastName, String firstName, int yearLevel, String course) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO students (id, last_name, first_name,  year_level, course) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, idNumber);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, firstName);
            preparedStatement.setInt(4, yearLevel);
            preparedStatement.setString(5, course);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
  public static List<Student> readStudents() {
    List<Student> studentList = new ArrayList<>();

    try (Connection connection = DatabaseConnector.getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM students")) {

        while (resultSet.next()) {
            String idNumber = resultSet.getString("id");
            String lastName = resultSet.getString("last_name");
            String firstName = resultSet.getString("first_name");
            int yearLevel = resultSet.getInt("year_level");
            String course = resultSet.getString("course");

            Student student = new Student();
            student.setIdNumber(idNumber);
            student.setLastName(lastName);
            student.setFirstName(firstName);
            student.setYearLevel(yearLevel);
            student.setCourse(course);


            studentList.add(student);
        }
    }catch (SQLException e) {
        e.printStackTrace();
        // Handle exceptions appropriately
    }
    return studentList; // Return the list of students
  }
}