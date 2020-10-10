package com.hospital.model;

public class Patient {
	private int pid;
	private String pname;
	private int pphone;
	private String disease;

	public Patient() {
		super();
	}

	public Patient(int pid, String pname, int pphone, String disease) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pphone = pphone;
		this.disease = disease;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPphone() {
		return pphone;
	}

	public void setPphone(int pphone) {
		this.pphone = pphone;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", pphone=" + pphone + ", disease=" + disease + "]";
	}

}
