package com.sus.papersystem.beans;

public class User {
	private int yhid;//用户编号
	private String mm;//密码
	private String xm;//姓名
	private String xy;//学院
	private String zy;//专业
	private String jc;//届次
	
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getXy() {
		return xy;
	}

	public void setXy(String xy) {
		this.xy = xy;
	}

	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

	public String getJc() {
		return jc;
	}

	public void setJc(String jc) {
		this.jc = jc;
	}

	public int getYhid() {
		return yhid;
	}

	public void setYhid(int yhid) {
		this.yhid = yhid;
	}

	public String getMm() {
		return mm;
	}

	public void setMm(String mm) {
		this.mm = mm;
	}

	@Override
	public String toString() {
		return "User [yhid=" + yhid + ", mm=" + mm + ", xm=" + xm + ", xy=" + xy + ", zy=" + zy + ", jc=" + jc + "]";
	}

	public User(int yhid, String mm, String xm, String xy, String zy, String jc) {
		super();
		this.yhid = yhid;
		this.mm = mm;
		this.xm = xm;
		this.xy = xy;
		this.zy = zy;
		this.jc = jc;
	}

	public User() { }
}
