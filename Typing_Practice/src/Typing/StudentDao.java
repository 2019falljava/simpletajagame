package Typing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 

public class StudentDao {
	 
private Connection conn;
private static final String USERNAME = "root";
private static final String PASSWORD = "mysql12!!";
private static final String URL = "jdbc:mysql://localhost:3306/haedal?useSSL=false";

public StudentDao() {
    // connection객체를 생성해서 디비에 연결해줌..
    try {
        Class.forName("com.mysql.jdbc.Driver");

        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("클래스 적재 실패!!");
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("연결 실패!!");
    }
}

public void insertStudent(Student student) {
    String sql = "insert into student(name,grade) values(?,?);";
    PreparedStatement pstmt = null;
    String name;
    int grade;
    name=student.getName();
    grade=student.getGrade();
    try {
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setInt(2, grade);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally {
        try {
            if (pstmt != null && !pstmt.isClosed())
                pstmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

public List<Student> slectAll() {
    String sql = "select * from student order by grade;";
    PreparedStatement pstmt = null;

    List<Student> list = new ArrayList<Student>();

    try {
        pstmt = conn.prepareStatement(sql);
        ResultSet re = pstmt.executeQuery();

        while (re.next()) {
            Student s = new Student();
            s.setId(re.getInt("id"));
            s.setName(re.getString("name"));
            s.setGrade(re.getInt("grade"));
            list.add(s);
        }

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally {
        try {
            if (pstmt != null && !pstmt.isClosed())
                pstmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    return list;
}
}


