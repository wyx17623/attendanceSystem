package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.vo.managerlist;

public class actionmanager {
	String userid ;
	String fullname ;
	String telephone ;
	String password;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public actionmanager() {
		super();
	}
	public actionmanager(String userid, String fullname, String telephone,
			String password) {
		super();
		this.userid = userid;
		this.fullname = fullname;
		this.telephone = telephone;
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void updatemanager() throws Exception{
		Connection conn = database.getConn();
		 String sql="update sys_user set fullname=?,telephone=? ,password=? where userid=?";			
		  PreparedStatement pstmt=conn.prepareStatement(sql);
		  int index=1;		  
		  pstmt.setString(index++, fullname);
		  pstmt.setString(index++, telephone);
		  pstmt.setString(index++, password);		
		  pstmt.setString(index++, userid);	
		  //2.5 执行SQL并返回执行结果
		  int count=pstmt.executeUpdate();
		  //2.6 关闭数据库连接资源
		 database.close(pstmt, conn);
	}
	
	public List<managerlist> listmanager() throws Exception{
		String keyword =null;
		return listmanager(keyword);
	}
	public List<managerlist> listmanager(String keyword) throws Exception
	{
		
						    				   				   				             
				StringBuffer sqlBuff = new StringBuffer();
				if(keyword!=null){
					sqlBuff.append("select userid, fullname,  telephone, password from sys_user where type='0' and fullname=?");
					
					
				}else if(keyword==null){
					sqlBuff.append("select userid, fullname,  telephone,  password from sys_user where type='0' ");
					
				}
				
				String sql = sqlBuff.toString();
			
				Connection conn = database.getConn();
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				if(keyword!=null){
					
					
					  pstmt.setString(1, "%"+keyword+"%");
					 
				}
				
				//2.4:PrepareStatement类型的对象pstmt执行SQL查询语句并返回结果
				ResultSet rs = pstmt.executeQuery();
				
				List<managerlist> ls =new ArrayList<managerlist>();
				while (rs.next()) {
				 userid=rs.getString("userid");
				 fullname=rs.getString("fullname");		
				 telephone=rs.getString("telephone");
				
				String  password=rs.getString("password");
				
				
				managerlist sl =new managerlist(userid,  fullname, telephone,  password);
				ls.add(sl);
			
	}
				return ls;
	}
}
