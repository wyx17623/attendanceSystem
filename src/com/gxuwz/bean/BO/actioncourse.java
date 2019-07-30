package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.vo.courselist;

public class actioncourse {
	private String courseID;
	private String courseName;
	private String credit;
	private String teacherID;
	private String period;
	private String courseTime;
	private String courseSite;
	private String term;
	private String classID;
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public actioncourse() {
		super();
	}
	
	public actioncourse(String courseID, String courseName, String credit,
			String teacherID, String period, String courseTime,
			String courseSite, String term, String classID) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.credit = credit;
		this.teacherID = teacherID;
		this.period = period;
		this.courseTime = courseTime;
		this.courseSite = courseSite;
		this.term = term;
		this.classID = classID;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}
	public String getCourseSite() {
		return courseSite;
	}
	public void setCourseSite(String courseSite) {
		this.courseSite = courseSite;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public void addcourse() throws Exception{
		
		Connection conn = database.getConn();
		 String sql="insert into sys_course (courseID,courseName,credit,teacherID,period,courseTime,courseSite,term,classID) values(?,?,?,?,?,?,?,?,?);";			
		   PreparedStatement pstmt=conn.prepareStatement(sql);
		  int index=1;
		  pstmt.setString(index++, courseID);			  
		  pstmt.setString(index++, courseName);
		  pstmt.setString(index++, credit);
		  pstmt.setString(index++, teacherID);
		  pstmt.setString(index++,period);
		  pstmt.setString(index++, courseTime);
		  pstmt.setString(index++, courseSite);
		  pstmt.setString(index++, term);
		  pstmt.setString(index, classID);
		  //2.5 执行SQL并返回执行结果
		  int count=pstmt.executeUpdate();
		  //2.6 关闭数据库连接资源
		 database.close(pstmt, conn);
		
	}
	public void updatecourse() throws Exception{
		Connection conn = database.getConn();
		 String sql="update sys_course set courseName=?,credit=?,teacherID=?,period=?,courseTime=?,courseSite=?,term=? ,classID=? where courseID=?";			
		  PreparedStatement pstmt=conn.prepareStatement(sql);
		  int index=1;		  
		  pstmt.setString(index++, courseName);
		  pstmt.setString(index++, credit);
		  pstmt.setString(index++, teacherID);
		  pstmt.setString(index++,period);
		  pstmt.setString(index++, courseTime);
		  pstmt.setString(index++, courseSite);
		  pstmt.setString(index++, term);
		  pstmt.setString(index++, classID);	
		  pstmt.setString(index, courseID);	
		  //2.5 执行SQL并返回执行结果
		  int count=pstmt.executeUpdate();
		  //2.6 关闭数据库连接资源
		 database.close(pstmt, conn);
	}
	public void removecourse(String courseID) throws Exception{
		Connection conn = database.getConn();
		  String sql="delete from sys_course where courseID=?";
		  
		   PreparedStatement pstmt=conn.prepareStatement(sql);
		  
		   int parameterIndex=1;
		   pstmt.setString(parameterIndex, courseID);
		  
		   int count=pstmt.executeUpdate();
		
		    database.close(pstmt, conn);
	}
	public List<courselist> listcourse() throws Exception{
		String keyword =null;
		return listcourse(keyword);
	}
	public List<courselist> listcourse(String keyword) throws Exception
	{
		  
						    				   				   				             
				StringBuffer sqlBuff = new StringBuffer();
				if(keyword!=null){
					sqlBuff.append("select courseID,teacherName,courseName,credit,term,courseSite ,courseTime,period,className from sys_course,sys_teacher,sys_classes where sys_course.teacherID=sys_teacher.teacherID and sys_course.classID=sys_classes.classID courseName like ?");
					
					
				}else if(keyword==null){
					sqlBuff.append("select courseID,teacherName,courseName,credit,term,courseSite ,courseTime,period,className from sys_course,sys_teacher,sys_classes where sys_course.teacherID=sys_teacher.teacherID and sys_course.classID=sys_classes.classID ");
					
				}
				
				String sql = sqlBuff.toString();
			
				Connection conn = database.getConn();
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				if(keyword!=null){
					
					
					  pstmt.setString(1, "%"+keyword+"%");
					 
				}
				
				//2.4:PrepareStatement类型的对象pstmt执行SQL查询语句并返回结果
				ResultSet rs = pstmt.executeQuery();
				//定义int序号变量
				
				List<courselist> ls =new ArrayList<courselist>();
				while (rs.next()) {
				 courseID=rs.getString("courseID");
				 courseName=rs.getString("courseName");		
				 credit=rs.getString("credit");
				String teacherName=rs.getString("teacherName");
				String period=rs.getString("period");
				String  courseTime=rs.getString("courseTime");
				
				courseSite=rs.getString("courseSite");
				 term=rs.getString("term");	
				 String className = rs.getString("className");
				 System.out.println(className);
				courselist sl =new courselist(courseID, courseName, credit, teacherName,  period,  courseTime, courseSite, term,className);
				ls.add(sl);
			
	}
				return ls;
	}
}
