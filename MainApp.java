package main;
import java.util.*;
import dao.StudentDAO;
import model.Student;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while(true) {
            System.out.println("\n1.Add Student\n2.View Students\n3.Delete Student\n4.Exit");
            int ch = sc.nextInt();

            if(ch == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                System.out.print("Enter Name: ");
                String name = sc.next();
                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                System.out.print("Enter Course: ");
                String course = sc.next();

                Student s = new Student(id, name, age, course);
                dao.addStudent(s);
            }
            else if(ch == 2) {
                dao.viewStudents();
            }
            else if(ch == 3) {
                System.out.print("Enter ID to delete: ");
                int id = sc.nextInt();
                dao.deleteStudent(id);
            }
            else {
                System.exit(0);
            }
        }
    }
}
