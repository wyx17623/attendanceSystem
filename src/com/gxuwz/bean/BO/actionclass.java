package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.entity.sys_classes;
import com.gxuwz.bean.vo.courselist;

public class actionclass {
	private String classID ;
	private String className ;
	private int stuNum ;
	public String getClassID() {
		return classID;
	}
	public actionclass() {
		super();
	}
	public actionclass(String classID, String className, int stuNum,
			String grade, String speID) {
		super();
		this.classID = classID;
		this.className = className;
		this.stuNum = stuNum;
		this.grade = grade;
		this.speID = speID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int  getStuNum() {
		return stuNum;
	}
	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSpeID() {
		return speID;
	}
	public void setSpeID(String speID) {
		this.speID = speID;
	}
	private String grade ;
	private String speID ;
  public List<sys_classes> listclasses () throws Exception{
	           
String sql="select * from sys_classes";


Connection conn = database.getConn();

PreparedStatement pstmt = conn.prepareStatement(sql);

ResultSet rs = pstmt.executeQuery();
//定义int序号变量

List<sys_classes> ls =new ArrayList<sys_classes>();
while (rs.next()) {
classID=rs.getString("classID");
className=rs.getString("className");		
stuNum=rs.getInt("stuNum");
 grade=rs.getString("grade");
speID=rs.getString("speID");

sys_classes sl =new sys_classes(classID, className, stuNum, grade, speID);
ls.add(sl);

}
	  
	  return ls;
  }
  public void  addclasses () throws Exception{
      
	  String sql="insert into sys_classes(classID,className,grade,depID) values(?,?,?,?)";

	  Connection conn = database.getConn();

	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  int Index=1;
	   pstmt.setString(Index++, classID);
	   pstmt.setString(Index++, className);
	   pstmt.setString(Index++, grade);
	   pstmt.setString(Index++, speID);
	   pstmt.executeUpdate();
	  //定义int序号变量

	  	  
	  	  
	    }
public void  updateclasses () throws Exception{
      
	  String sql="update sys_classes set className=?,stuNum=?,grade=?,speID=? where classID=?";

	  Connection conn = database.getConn();

	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  int Index=1;
	   pstmt.setString(Index++, className);
	   pstmt.setInt(Index++, stuNum);
	   pstmt.setString(Index++, grade);
	   pstmt.setString(Index++, speID);
	   pstmt.setString(Index++, classID);
	   pstmt.executeUpdate();
	  //定义int序号变量

	  	  
	  	  
	    }
public void removeclasses(String classID) throws Exception{
	Connection conn = database.getConn();
	  String sql="delete from sys_classes where classID=?";
	  
	   PreparedStatement pstmt=conn.prepareStatement(sql);
	  
	   int parameterIndex=1;
	   pstmt.setString(parameterIndex, classID);
	  
	   int count=pstmt.executeUpdate();
	
	    database.close(pstmt, conn);
}
}
