package com.gxuwz.bean.BO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.vo.studentlist;

/*
 * 学生处理类
 */
public class actionstudent {
	String stuID;
	String stuName;
	String sex;
	String classID;
	String depID;
	String speID;
	String stuTel;
	String address;
	    public actionstudent() {
	      }
		public actionstudent(String stuID, String stuName, String sex,
			String classID, String depID, String speID, String stuTel,
			String address) {
		super();
		this.stuID = stuID;
		this.stuName = stuName;
		this.sex = sex;
		this.classID = classID;
		this.depID = depID;
		this.speID = speID;
		this.stuTel = stuTel;
		this.address = address;
	}
		public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public String getDepID() {
		return depID;
	}
	public void setDepID(String depID) {
		this.depID = depID;
	}
	public String getSpeID() {
		return speID;
	}
	public void setSpeID(String speID) {
		this.speID = speID;
	}
	public String getStuTel() {
		return stuTel;
	}
	public void setStuTel(String stuTel) {
		this.stuTel = stuTel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
		
		public void addstudent() throws Exception{
			
			Connection conn = database.getConn();
			 String sql="insert into sys_student(stuID,stuName,sex,classID,depID,speID,stuTel,address)values(?,?,?,?,?,?,?,?);";			
			   PreparedStatement pstmt=conn.prepareStatement(sql);
			  int index=1;
			  pstmt.setString(index++, stuID);			  
			  pstmt.setString(index++, stuName);
			  pstmt.setString(index++, sex);
			  pstmt.setString(index++, classID);
			  pstmt.setString(index++,depID);
			  pstmt.setString(index++, speID);
			  pstmt.setString(index++, stuTel);
			  pstmt.setString(index, address);
			  //2.5 执行SQL并返回执行结果
			  int count=pstmt.executeUpdate();
			  //2.6 关闭数据库连接资源
			 database.close(pstmt, conn);
			
		}
		public void updatestudent() throws Exception{
			Connection conn = database.getConn();
			 String sql="update sys_student set stuName=?,sex=?,classID=?,depID=?,speID=?,stuTel=?,address=?  where stuID=?";			
			  PreparedStatement pstmt=conn.prepareStatement(sql);
			  int index=1;		  
			  pstmt.setString(index++, stuName);
			  pstmt.setString(index++, sex);
			  pstmt.setString(index++, classID);
			  pstmt.setString(index++,depID);
			  pstmt.setString(index++, speID);
			  pstmt.setString(index++, stuTel);
			  pstmt.setString(index++, address);
			  pstmt.setString(index, stuID);	
			  //2.5 执行SQL并返回执行结果
			  int count=pstmt.executeUpdate();
			  //2.6 关闭数据库连接资源
			 database.close(pstmt, conn);
		}
		public void removestudent(String stuID) throws Exception{
			Connection conn = database.getConn();
			  String sql="delete from sys_student where stuID=?";
			  
			   PreparedStatement pstmt=conn.prepareStatement(sql);
			  
			   int parameterIndex=1;
			   pstmt.setString(parameterIndex, stuID);
			  
			   int count=pstmt.executeUpdate();
			
			    database.close(pstmt, conn);
		}
		public List<studentlist> liststudent() throws Exception{
			String stuID =null;
			return liststudent(stuID);
		}
		public List<studentlist> liststudent(String stuID) throws Exception
		{
			  
							    				   				   				             
					StringBuffer sqlBuff = new StringBuffer();
			
						sqlBuff.append("select sys_student.stuID,className,stuName,sex,address,stuTel ,depName,speName from sys_student,sys_classes,sys_department,sys_speciality  where  sys_speciality.speID=sys_student.speID and sys_student.classID=sys_classes.classID and sys_student.depID= sys_department.depID");
						
					
					
					String sql = sqlBuff.toString();
				
					Connection conn = database.getConn();
					
					PreparedStatement pstmt = conn.prepareStatement(sql);
				
					
					//2.4:PrepareStatement类型的对象pstmt执行SQL查询语句并返回结果
					ResultSet rs = pstmt.executeQuery();
					//定义int序号变量
					
					List<studentlist> ls =new ArrayList<studentlist>();
					while (rs.next()) {
					 stuID=rs.getString("stuID");
					 stuName=rs.getString("stuName");		
					 sex=rs.getString("sex");
					String className=rs.getString("className");
					String  depName=rs.getString("depName");
					String speName=rs.getString("speName");
					stuTel=rs.getString("stuTel");
					String address=rs.getString("address");	
					studentlist sl =new studentlist(stuID,  stuName,  sex,className,  depName,  speName,  stuTel, address);
					ls.add(sl);
				
		}
					return ls;
		}
}


