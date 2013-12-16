

import java.io.Serializable;
import java.sql.Date;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	// The id property holds a unique identifier value for a particular emp.
	private Integer eno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hiredate;
	private Double sal;
	private Double comm;
	private Department deptno;

	// The no-argument constructor is a requirement for all persistent classes
	public Employee() {
	}

	public Employee(String ename, Double sal) {
		this.ename = ename;
		this.sal = sal;
	}

	public Integer getEno() {
		return eno;
	}

	public void setEno(Integer eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public void setDeptno(Department deptno) {
		this.deptno = deptno;
	}

	public Department getDeptno() {
		return deptno;
	}

}
