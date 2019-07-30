package com.gxuwz.bean.vo;

//学生个人记录类
public class attendanceStulist {
	private String stuID;
	private String StuName;
	private String courseName;
	private String status;
	private String attendanceTime;
	public String getStuID() {
		return stuID;
	}

	public attendanceStulist() {
		super();
	}

	public attendanceStulist(String stuID, String stuName, String courseName,
			String status, String attendanceTime) {
		super();
		this.stuID = stuID;
		this.StuName = stuName;
		this.courseName = courseName;
		this.status = status;
		this.attendanceTime = attendanceTime;
	}

	public void setStuID(String stuID) {
		stuID = stuID;
	}

	public String getStuName() {
		return StuName;
	}

	public void setStuName(String stuName) {
		StuName = stuName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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

}
