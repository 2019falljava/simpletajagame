package Typing;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

public class StudentDB_Test {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StudentDao sDao = new StudentDao();
       Student student = new Student();
      
        student.setId(1);
        student.setGrade(123);
        student.setName("sds");
        sDao.insertStudent(student);
  
        
 
        

       
        List<Student> list = sDao.slectAll();
        
      //결과물 출력
        for(int i=0; i<list.size(); i++) {
        	System.out.println("회원아이디:"+list.get(i).getId()); 
        	System.out.println("회원이름:"+list.get(i).getName()); 
        	System.out.println("회원점수:"+list.get(i).getGrade());
        	System.out.println("----------------------------------");
        }

          
    }
}

