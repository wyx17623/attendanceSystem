package com.gxuwz.bean.vo;
/*
 * 临时对象用来存储显示student_list
 */
public class studentlist {
	String stuID;
	String stuName;
	String sex;
	String className;
	String depName;
	String speName;
	String stuTel;
	public studentlist(String stuID, String stuName, String sex,
			String className, String depName, String speName, String stuTel,
			String address) {
		super();
		this.stuID = stuID;
		this.stuName = stuName;
		this.sex = sex;
		this.className = className;
		this.depName = depName;
		this.speName = speName;
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
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getSpeName() {
		return speName;
	}
	public void setSpeName(String speName) {
		this.speName = speName;
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
	String address;
}
