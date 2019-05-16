package com.demo.po;

import java.util.List;

public class AreaPO {

	private int areaid;
	private String aname;
	private int aflag;
	private List<AuthorPO> alist;
	public List<AuthorPO> getAlist() {
		return alist;
	}
	public void setAlist(List<AuthorPO> alist) {
		this.alist = alist;
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
	public int getAflag() {
		return aflag;
	}
	public void setAflag(int aflag) {
		this.aflag = aflag;
	}
	
}
