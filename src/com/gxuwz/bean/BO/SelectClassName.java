package com.gxuwz.bean.BO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.bean.entity.sys_classes;
import com.gxuwz.bean.vo.managerlist;
import com.gxuwz.base.*;
public class SelectClassName {
     List<sys_classes> list =new ArrayList<sys_classes>();
     
     public List<sys_classes>  getClassName(String teacherID) throws Exception{
    	 Connection conn= database.getConn();
 		String sql="select sys_course.classID, className from sys_classes,sys_teacher,sys_course where sys_classes.classID=sys_course.classID and sys_teacher.teacherID = sys_course.teacherID and sys_course.teacherID=? ";
 	
 		PreparedStatement pstmt = conn.prepareStatement(sql);
 		int index=1;
		  pstmt.setString(index++, teacherID);
 		ResultSet rs = pstmt.executeQuery();
 		
 		
 		while (rs.next()) {
 		String  className=rs.getString("className");
 		String  classID=rs.getString("classID");
 		sys_classes sd = new sys_classes(classID, className);
 		list.add(sd);
 		}
 		return list;
    	 
     }
     
     
	public List<sys_classes>  getClassName() throws Exception{
		Connection conn= database.getConn();
		String sql="select * from sys_classes";
		PreparedStatement pstmt = conn.prepareStatement(sql);
	
		ResultSet rs = pstmt.executeQuery();
		
	
		while (rs.next()) {
		String  className=rs.getString("className");
		String  classID=rs.getString("classID");
		sys_classes sd = new sys_classes(classID, className);
		list.add(sd);
		}
		return list;
		
	}
	
}
