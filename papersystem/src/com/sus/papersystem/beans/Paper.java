package com.sus.papersystem.beans;

public class Paper {
	private int lwid;//论文编号
	private String lwtm;//论文题目
	private String gjc;//关键词
	private String zhy;//摘要
	private String xm;//姓名
	private String xy;//学院
	private String zy;//专业
	private String jc;//届次
	private String zdls;//指导老师
	private String jb;//级别
	private String nr;//内容
	private int jxmsid;//上传者
	
	
	public String getJc() {
		return jc;
	}
	public void setJc(String jc) {
		this.jc = jc;
	}
	public String getZdls() {
		return zdls;
	}
	public void setZdls(String zdls) {
		this.zdls = zdls;
	}
	public String getJb() {
		return jb;
	}
	public void setJb(String jb) {
		this.jb = jb;
	}
	public String getNr() {
		return nr;
	}
	public void setNr(String nr) {
		this.nr = nr;
	}
	public Paper() {}
	public int getLwid() {
		return lwid;
	}
	public void setLwid(int lwid) {
		this.lwid = lwid;
	}
	public String getLwtm() {
		return lwtm;
	}
	public void setLwtm(String lwtm) {
		this.lwtm = lwtm;
	}
	public String getGjc() {
		return gjc;
	}
	public void setGjc(String gjc) {
		this.gjc = gjc;
	}
	public String getZhy() {
		return zhy;
	}
	public void setZhy(String zhy) {
		this.zhy = zhy;
	}
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
	
	public int getJxmsid() {
		return jxmsid;
	}
	public void setJxmsid(int jxmsid) {
		this.jxmsid = jxmsid;
	}
	public Paper(int lwid, String lwtm, String gjc, String zhy, String xm, String xy, String zy, String jc, String zdls,
			String jb, String nr, int jxmsid) {
		this.lwid = lwid;
		this.lwtm = lwtm;
		this.gjc = gjc;
		this.zhy = zhy;
		this.xm = xm;
		this.xy = xy;
		this.zy = zy;
		this.jc = jc;
		this.zdls = zdls;
		this.jb = jb;
		this.nr = nr;
		this.jxmsid = jxmsid;
	}
	
}
