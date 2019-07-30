package com.gxuwz.bean.BO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.bean.entity.sys_speciality;
import com.gxuwz.bean.vo.managerlist;
import com.gxuwz.base.*;
public class SelectSpeciality {
     List<sys_speciality> list =new ArrayList<sys_speciality>();
     
	public List<sys_speciality>  getSpeName() throws Exception{
		Connection conn= database.getConn();
		String sql="select * from sys_speciality";
		PreparedStatement pstmt = conn.prepareStatement(sql);
	
		ResultSet rs = pstmt.executeQuery();
		
	
		while (rs.next()) {
		String  speName=rs.getString("speName");
		String  speID=rs.getString("speID");
		sys_speciality sd = new sys_speciality(speID, speName);
		list.add(sd);
		}
		return list;
		
	}
	
}
