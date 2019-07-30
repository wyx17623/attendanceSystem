package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.vo.attendanceStulist;
import com.gxuwz.bean.vo.attendancelist;
import com.gxuwz.bean.vo.attendancelistrecord;
import com.gxuwz.bean.vo.listattendanceStatistics;
import com.gxuwz.bean.vo.studentlist;

public class actionattendance {

	public actionattendance(String stuID, String courseID, String status,
			String attendanceTime, String classID) {
		super();
		this.stuID = stuID;
		this.classID = classID;
		this.courseID = courseID;
		this.status = status;
		this.attendanceTime = attendanceTime;
	}

	public String getStuID() {
		return stuID;
	}

	public void setStuID(String stuID) {
		this.stuID = stuID;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAttendanceTime() {
		return attendanceTime;
	}

	public void setAttendanceTime(String attendanceTime) {
		this.attendanceTime = attendanceTime;
	}

	private String stuID;
	private String classID;
	private String courseID;
	private String status;
	private String attendanceTime;

	// 将考勤的情况插入考勤表
	public void addattendance(String stuID, String courseID, String status,
			String attendanceTime, String classID) throws Exception {

		Connection conn = database.getConn();
		String sql = "insert into sys_attendancesheet(stuID,courseID,status,attendanceTime,classID)values(?,?,?,?,?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int index = 1;

		pstmt.setString(index++, stuID);
		pstmt.setString(index++, courseID);
		pstmt.setString(index++, status);
		pstmt.setString(index++, attendanceTime);
		pstmt.setString(index++, classID);
		// 2.5 执行SQL并返回执行结果
		int count = pstmt.executeUpdate();
		// 2.6 关闭数据库连接资源
		database.close(pstmt, conn);

	}

	// 考勤列表，显示待考勤的学生
	public List<attendancelist> listattendance(String classID) throws Exception {

		StringBuffer sqlBuff = new StringBuffer();

		sqlBuff.append("select stuID,className,stuName from sys_student,sys_classes where  sys_student.classID=sys_classes.classID and sys_classes.classID=?");

		String sql = sqlBuff.toString();

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);

		int index = 1;
		pstmt.setString(index++, classID);
		ResultSet rs = pstmt.executeQuery();

		List<attendancelist> ls = new ArrayList<attendancelist>();
		while (rs.next()) {
			stuID = rs.getString("stuID");
			String stuName = rs.getString("stuName");
			String className = rs.getString("className");
			attendancelist sl = new attendancelist(stuID, stuName, className);
			ls.add(sl);

		}
		return ls;
	}

	public actionattendance() {
		super();
	}

	public List<attendancelist> listattendance(String classID,
			String attendanceTime) throws Exception {
		StringBuffer sqlBuff = new StringBuffer();
		sqlBuff.append("select sys_student.stuID,className,stuName,status from sys_student,sys_classes,sys_attendancesheet where  sys_student.classID=sys_classes.classID and sys_attendancesheet.stuID=sys_student.stuID and attendanceTime=?");
		String sql = sqlBuff.toString();
		Connection conn = database.getConn();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int index = 1;
		pstmt.setString(index++, attendanceTime);
		ResultSet rs = pstmt.executeQuery();
		List<attendancelist> ls = new ArrayList<attendancelist>();
		while (rs.next()) {
			stuID = rs.getString("stuID");
			String stuName = rs.getString("stuName");
			String className = rs.getString("className");
			status = rs.getString("status");
			attendancelist sl = new attendancelist(stuID, stuName, className,
					status);
			ls.add(sl);
		}
		return ls;
	}

	// 教师查询考勤情况
	public List<attendancelistrecord> listattendancerecord(String teacherID)
			throws Exception {
		String sql = "select DISTINCT sys_classes.classID,className,courseName,attendanceTime from sys_classes,sys_attendancesheet,sys_course where  sys_attendancesheet.classID=sys_classes.classID and sys_attendancesheet.courseID=sys_course.courseID and sys_course.teacherID=?";
		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);

		int index = 1;
		pstmt.setString(index++, teacherID);

		ResultSet rs = pstmt.executeQuery();

		List<attendancelistrecord> ls = new ArrayList<attendancelistrecord>();
		while (rs.next()) {
			classID = rs.getString("classID");
			String className = rs.getString("className");
			String courseName = rs.getString("courseName");
			attendanceTime = rs.getString("attendanceTime");
			attendancelistrecord sl = new attendancelistrecord(classID,
					className, courseName, attendanceTime);
			ls.add(sl);

		}
		return ls;
	}// 学生查询个人记录

	public List<attendanceStulist> listStuattendancerecord(String stuID)
			throws Exception {
		String sql = "select stuName,courseName,status,attendanceTime from sys_attendancesheet,sys_course,sys_student where sys_attendancesheet.stuID=sys_student.stuID and sys_attendancesheet.courseID=sys_course.courseID and sys_attendancesheet.stuID=?";
		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);

		int index = 1;
		pstmt.setString(index++, stuID);

		ResultSet rs = pstmt.executeQuery();

		List<attendanceStulist> ls = new ArrayList<attendanceStulist>();
		while (rs.next()) {

			String stuName = rs.getString("stuName");
			String courseName = rs.getString("courseName");
			String status = rs.getString("status");
			if (status.equals("0")) {
				status = "早退";
			}
			if (status.equals("1")) {
				status = "迟到";
			}
			if (status.equals("2")) {
				status = "旷课";
			}
			if (status.equals("3")) {
				status = "请假";
			}
			if (status.equals("4")) {
				status = "正常";
			}
			attendanceTime = rs.getString("attendanceTime");

			attendanceStulist sl = new attendanceStulist(stuID, stuName,
					courseName, status, attendanceTime);
			ls.add(sl);

		}
		return ls;
	}

	// 教师按条件查询
	public List<listattendanceStatistics> attendanceStatistics(String classID,
			String status) throws Exception {

		Connection conn = database.getConn();
		String sql = "select sys_student.stuID,stuName,className,status,courseName,count(status) from sys_student,sys_classes,sys_attendancesheet,sys_course where  sys_student.stuID =sys_attendancesheet.stuID and sys_attendancesheet.classID=sys_classes.classID and sys_course.courseID=sys_attendancesheet.courseID and sys_attendancesheet.classID=? and status =? GROUP BY(sys_student.stuID)";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		int index = 1;
		pstmt.setString(index++, classID);
		pstmt.setString(index++, status);
		ResultSet rs = pstmt.executeQuery();

		List<listattendanceStatistics> ls = new ArrayList<listattendanceStatistics>();
		while (rs.next()) {
			stuID = rs.getString("stuID");
			String stuName = rs.getString("stuName");
			String className = rs.getString("className");
			status = rs.getString("status");
			if (status.equals("0")) {
				status = "早退";
			}
			if (status.equals("1")) {
				status = "迟到";
			}
			if (status.equals("2")) {
				status = "旷课";
			}
			if (status.equals("3")) {
				status = "请假";
			}
			if (status.equals("4")) {
				status = "正常";
			}
			String courseName = rs.getString("courseName");
			String amount = rs.getString("count(status)");
			listattendanceStatistics sl = new listattendanceStatistics(stuID,
					stuName, className, status, courseName, amount);
			ls.add(sl);
		}
		return ls;
	}

	// 学生按条件查询
	public List<listattendanceStatistics> attendanceStuStatistics(String stuID,
			String status) throws Exception {

		Connection conn = database.getConn();
		String sql = "select sys_student.stuID,stuName,status,courseName,count(*) from sys_student,sys_attendancesheet,sys_course where  sys_student.stuID =sys_attendancesheet.stuID and sys_attendancesheet.courseID=sys_course.courseID and sys_attendancesheet.stuID=? and status =? GROUP BY(sys_attendancesheet.courseID)";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		int index = 1;
		pstmt.setString(index++, stuID);
		pstmt.setString(index++, status);
		ResultSet rs = pstmt.executeQuery();
		// 按条件查询
		List<listattendanceStatistics> ls = new ArrayList<listattendanceStatistics>();
		while (rs.next()) {
			stuID = rs.getString("stuID");
			String stuName = rs.getString("stuName");
			status = rs.getString("status");
			if (status.equals("0")) {
				status = "早退";
			}
			if (status.equals("1")) {
				status = "迟到";
			}
			if (status.equals("2")) {
				status = "旷课";
			}
			if (status.equals("3")) {
				status = "请假";
			}
			if (status.equals("4")) {
				status = "正常";
			}
			String courseName = rs.getString("courseName");
			String amount = rs.getString("count(*)");

			listattendanceStatistics sl = new listattendanceStatistics(stuID,
					stuName, status, courseName, amount);
			ls.add(sl);
		}
		return ls;
	}
}
