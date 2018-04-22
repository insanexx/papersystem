package com.sus.papersystem.beans;

public class Teacher {
	private int jxmsid;//教学秘书编号
	private String xm;//姓名
	private String mm;//密码
	private String xy;//学院
	
	public int getJxmsid() {
		return jxmsid;
	}

	public void setJxmsid(int jxmsid) {
		this.jxmsid = jxmsid;
	}


	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getMm() {
		return mm;
	}

	public void setMm(String mm) {
		this.mm = mm;
	}

	public String getXy() {
		return xy;
	}

	public void setXy(String xy) {
		this.xy = xy;
	}

	public Teacher() {}

	@Override
	public String toString() {
		return "Teacher [jxmsid=" + jxmsid + ", xm=" + xm + ", mm=" + mm + ", xy=" + xy + "]";
	}

	public Teacher(int jxmsid, String xm, String mm, String xy) {
		this.jxmsid = jxmsid;
		this.xm = xm;
		this.mm = mm;
		this.xy = xy;
	}
	
}
