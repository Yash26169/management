package com.hospital.model;

public class OtherStaff {
	private int sid;
	private String sname;
	private String semail;
	private int sphone;
	private String designation;
	private String shift;

	public OtherStaff() {
		super();
	}

	public OtherStaff(int sid, String sname, String semail, int sphone, String designation, String shift) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.semail = semail;
		this.sphone = sphone;
		this.designation = designation;
		this.shift = shift;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public int getSphone() {
		return sphone;
	}

	public void setSphone(int sphone) {
		this.sphone = sphone;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	@Override
	public String toString() {
		return "OtherStaff [sid=" + sid + ", sname=" + sname + ", semail=" + semail + ", sphone=" + sphone
				+ ", designation=" + designation + ", shift=" + shift + "]";
	}

}
