package com.gxuwz.bean.BO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.bean.entity.sys_classes;
import com.gxuwz.bean.vo.managerlist;
import com.gxuwz.base.*;
public class SelectCourseID {   
	
     public String  getCourseID(String teacherID) throws Exception{
    	 String courseID = null;
    	 Connection conn= database.getConn();
  String sql=" select courseID from sys_classes,sys_teacher,sys_course where sys_course.teacherID=sys_teacher.teacherID and sys_course.classID=sys_classes.classID and sys_teacher.teacherID=?" ;
        PreparedStatement pstmt = conn.prepareStatement(sql);
 		int index=1;
		  pstmt.setString(index++, teacherID);
		
 		ResultSet rs = pstmt.executeQuery();
             rs.next();
             courseID=rs.getString("courseID");
		     return courseID;
    	 
     }
    
     public String  getCourseID(String teacherID,String classID) throws Exception{
    	 String courseID = null;
    	 Connection conn= database.getConn();
  String sql="select courseID from sys_classes,sys_teacher,sys_course where sys_course.teacherID=sys_teacher.teacherID and sys_course.classID=sys_classes.classID and sys_teacher.teacherID=? and sys_classes.classID=?" ;
        PreparedStatement pstmt = conn.prepareStatement(sql);
 		int index=1;
		  pstmt.setString(index++, teacherID);
		  pstmt.setString(index++, classID);
		
 		ResultSet rs = pstmt.executeQuery();
             rs.next();
             courseID=rs.getString("courseID");
		     return courseID;
    	 
     }
}
