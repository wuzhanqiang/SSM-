package com.demo.po;

import java.sql.Date;

public class AuthorPO {
	private int authorid;
	private AreaPO area;   /*映射多对一关系*/
	private String aname;
	private String bname;
	private int sex;
	private Date birthday;
	private String tel;    /*类中的属性名和数据库中的列名没不一致*/
	private String address;
	private int aflag;
	
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public AreaPO getArea() {
		return area;
	}
	public void setArea(AreaPO area) {
		this.area = area;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
}
