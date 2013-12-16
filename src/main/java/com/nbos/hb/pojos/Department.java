package com.nbos.hb.pojos;

import java.util.Set;

public class Department {
	private Integer dno;
	private String dname;
	private String dloc;
	private Set<Employee> emp;

	public Department(){
	}

	//setters and getters
	
	public void setDno(Integer dno) {
		this.dno = dno;
	}

	public Integer getDno() {
		return dno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDloc() {
		return dloc;
	}

	public void setDloc(String dloc) {
		this.dloc = dloc;
	}

	public void setEmp(Set<Employee> emp) {
		this.emp = emp;
	}

	public Set<Employee> getEmp() {
		return emp;
	}

}
