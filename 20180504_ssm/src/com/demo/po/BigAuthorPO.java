package com.demo.po;

import java.sql.Date;

public class BigAuthorPO {

	private int authorid;
	private int areaid;
	private String aname;
	private String bname;
	private int sex;
	private Date birthday;
	private String phone;
	private String address;
	private int aflag;
	private String areaname;
	private int areaflag;
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public int getAreaid() {
		return areaid;
	}
	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAflag() {
		return aflag;
	}
	public void setAflag(int aflag) {
		this.aflag = aflag;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public int getAreaflag() {
		return areaflag;
	}
	public void setAreaflag(int areaflag) {
		this.areaflag = areaflag;
	}
}
