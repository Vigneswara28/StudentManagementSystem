package dao;
import model.Student;
import util.DBConnection;
import java.sql.*;
import java.util.*;

public class StudentDAO {

    public void addStudent(Student s) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO students VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, s.getId());
        ps.setString(2, s.getName());
        ps.setInt(3, s.getAge());
        ps.setString(4, s.getCourse());
        ps.executeUpdate();
        System.out.println("Student Added Successfully!");
    }

    public void viewStudents() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM students");

        while(rs.next()) {
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
        }
    }

    public void deleteStudent(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "DELETE FROM students WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Student Deleted!");
    }
}
