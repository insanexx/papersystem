package com.sus.papersystem.beans;

public class Admin {
	private int glyid;//管理员编号
	private String xm;//姓名
	private String mm;//密码
	
	public int getGlyid() {
		return glyid;
	}

	public void setGlyid(int glyid) {
		this.glyid = glyid;
	}


	public String getMm() {
		return mm;
	}

	public void setMm(String mm) {
		this.mm = mm;
	}

	public Admin(){}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	@Override
	public String toString() {
		return "Admin [glyid=" + glyid + ", xm=" + xm + ", mm=" + mm + "]";
	}


}
