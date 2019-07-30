package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.vo.teacherlist;

public class actionteacher {

	String teacherID ;
	String teacherName ;
	String sex ;
	String telephone;
	String depID ;
	String resSec ;
	public actionteacher() {
	
	}
	public actionteacher(String teacherID, String teacherName, String sex,
			String telephone, String depID, String resSec) {
		super();
		this.teacherID = teacherID;
		this.teacherName = teacherName;
		this.sex = sex;
		this.telephone = telephone;
		this.depID = depID;
		this.resSec = resSec;
	}
	public String getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getDepID() {
		return depID;
	}
	public void setDepID(String depID) {
		this.depID = depID;
	}
	public String getResSec() {
		return resSec;
	}
	public void setResSec(String resSec) {
		this.resSec = resSec;
	}

	public void addteacher() throws Exception{
		
		Connection conn = database.getConn();
		  String sql="insert into sys_teacher(teacherID, teacherName,sex,telephone,depID, resSec)values(?,?,?,?,?,?)";
			
		  PreparedStatement pstmt=conn.prepareStatement(sql);
		  int index=1;
		  pstmt.setString(index++, teacherID);			  
		  pstmt.setString(index++, teacherName);
		  pstmt.setString(index++, sex);
		  pstmt.setString(index++, telephone);
		  pstmt.setString(index++,depID);
		  pstmt.setString(index++, resSec);
		
		  //2.5 执行SQL并返回执行结果
		  int count=pstmt.executeUpdate();
		  //2.6 关闭数据库连接资源
		 database.close(pstmt, conn);
		
	}
	public void updateteacher() throws Exception{
		Connection conn = database.getConn();
		 String sql="update sys_teacher set teacherName=?,sex=?,telephone=?,depID=?,resSec=?  where teacherID=?";			
		  PreparedStatement pstmt=conn.prepareStatement(sql);
		  int index=1;		  
		  pstmt.setString(index++, teacherName);
		  pstmt.setString(index++, sex);
		  pstmt.setString(index++, telephone);
		  pstmt.setString(index++,depID);
		  pstmt.setString(index++, resSec);
		
		  pstmt.setString(index++, teacherID);	
		  //2.5 执行SQL并返回执行结果
		  int count=pstmt.executeUpdate();
		  //2.6 关闭数据库连接资源
		 database.close(pstmt, conn);
	}
	public void removeteacher(String teacherID) throws Exception{
		Connection conn = database.getConn();
		  String sql="delete from sys_teacher where teacherID=?";
		  
		   PreparedStatement pstmt=conn.prepareStatement(sql);
		  
		   int parameterIndex=1;
		   pstmt.setString(parameterIndex, teacherID);
		  
		   int count=pstmt.executeUpdate();
		
		    database.close(pstmt, conn);
	}
	public List<teacherlist> listteacher() throws Exception{
		String keyword =null;
		return listteacher(keyword);
	}
	public List<teacherlist> listteacher(String keyword) throws Exception
	{
		
						    				   				   				             
				StringBuffer sqlBuff = new StringBuffer();
				if(keyword!=null){
					sqlBuff.append("select teacherID, teacherName,  sex, telephone,  depName,  resSec from sys_teacher,sys_department where sys_teacher.depID=sys_department.depID and teacherName=?");
					
					
				}else if(keyword==null){
					sqlBuff.append("select teacherID, teacherName,  sex, telephone,  depName,  resSec from sys_teacher,sys_department where sys_teacher.depID=sys_department.depID ");
					
				}
				
				String sql = sqlBuff.toString();
			
				Connection conn = database.getConn();
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				if(keyword!=null){
					
					
					  pstmt.setString(1, "%"+keyword+"%");
					 
				}
				
				//2.4:PrepareStatement类型的对象pstmt执行SQL查询语句并返回结果
				ResultSet rs = pstmt.executeQuery();
				
				List<teacherlist> ls =new ArrayList<teacherlist>();
				while (rs.next()) {
				 teacherID=rs.getString("teacherID");
				 teacherName=rs.getString("teacherName");		
				 sex=rs.getString("sex");
				telephone=rs.getString("telephone");
				String  depName=rs.getString("depName");
				resSec=rs.getString("resSec");
				
				teacherlist sl =new teacherlist(teacherID,  teacherName,  sex,telephone,  depName,  resSec);
				ls.add(sl);
			
	}
				return ls;
	}
}
