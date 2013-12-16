package com.nbos.hb.pojos;

public class Employee {
	// The id property holds a unique identifier value for a particular emp.
	private Integer eid;
	private String ename;
	private Double sal;
	private Department deptno;

	// The no-argument constructor is a requirement for all persistent classes
	public Employee() {
	}

	// setters and getters
	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Department getDeptno() {
		return deptno;
	}

	public void setDeptno(Department deptno) {
		this.deptno = deptno;
	}

}