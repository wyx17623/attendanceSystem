package com.gxuwz.bean.vo;

public class courselist {
	private String courseID;
	private String courseName;
	private String credit;
	private String teacherName;
	private String className;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	public courselist(String courseID, String courseName, String credit,
			String teacherName,  String period,
			String courseTime, String courseSite, String term,String className) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.credit = credit;
		this.teacherName = teacherName;
		this.className = className;
		this.period = period;
		this.courseTime = courseTime;
		this.courseSite = courseSite;
		this.term = term;
	}
	public courselist() {
		super();
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
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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
	private String period;
	private String courseTime;
	private String courseSite;
	private String term;
}
