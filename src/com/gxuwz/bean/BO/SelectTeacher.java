package com.gxuwz.bean.BO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.gxuwz.bean.entity.sys_teacher;
import com.gxuwz.base.*;

public class SelectTeacher {
     List<sys_teacher> list =new ArrayList<sys_teacher>();
     
	public List<sys_teacher>  getTeacher() throws Exception{
		Connection conn= database.getConn();
		String sql="select * from sys_teacher";
		PreparedStatement pstmt = conn.prepareStatement(sql);
	
		ResultSet rs = pstmt.executeQuery();
		
		
		while (rs.next()) {
		String  teacherID=rs.getString("teacherID");
		String  teacherName=rs.getString("teacherName");
		sys_teacher sd = new sys_teacher(teacherID, teacherName);
		list.add(sd);
		}
		database.close(rs, pstmt,conn);
		return list;
		
	}
	
}
