package com.gxuwz.bean.BO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.bean.entity.sys_department;
import com.gxuwz.bean.vo.managerlist;
import com.gxuwz.base.*;
public class SelectDepName {
     List<sys_department> list =new ArrayList<sys_department>();
     
	public List<sys_department>  getDepName() throws Exception{
		Connection conn= database.getConn();
		String sql="select * from sys_department";
		PreparedStatement pstmt = conn.prepareStatement(sql);
	
		ResultSet rs = pstmt.executeQuery();
		
		
		while (rs.next()) {
		String  depName=rs.getString("depName");
		String  depID=rs.getString("depID");
		sys_department sd = new sys_department(depID, depName);
		list.add(sd);
		}
		return list;
		
	}
	
}
