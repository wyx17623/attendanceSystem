package com.gxuwz.bean.entity;

public class sys_teacher {
	 private  String teacherID;
	  private  String teacherName;
	  private  String  sex;
	  private  String telephone;
	  private  String deID;
	  public sys_teacher(String teacherID, String teacherName, String sex,
			String telephone, String deID, String resSec) {
		super();
		this.teacherID = teacherID;
		this.teacherName = teacherName;
		this.sex = sex;
		this.telephone = telephone;
		this.deID = deID;
		this.resSec = resSec;
	}
	
	public sys_teacher(String teacherID, String teacherName) {
		super();
		this.teacherID = teacherID;
		this.teacherName = teacherName;
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
	public String getDeID() {
		return deID;
	}
	public void setDeID(String deID) {
		this.deID = deID;
	}
	public String getResSec() {
		return resSec;
	}
	public void setResSec(String resSec) {
		this.resSec = resSec;
	}
	private  String resSec;
}
