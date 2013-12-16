package com.nbos.hb.service.projections;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.nbos.hb.util.HibernateUtilities;

//using the different methods of Projections
public class ProjectionsMethodsEx {

	// getting a named logger
	static Logger log = Logger.getLogger("hib");

	public static void eCount(Session s) {
		// creating a Criteria instance
		Criteria cr = s.createCriteria("Emp").setProjection(
				Projections.count("eid"));
		Integer eCount = (Integer) cr.list().get(0);
		log.info("no. of employees i.e., count(eid) : " + eCount);
	}

	public static void countDistinctDept(Session s) {
		// creating a Criteria instance
		Criteria cr = s.createCriteria("Emp").setProjection(
				Projections.countDistinct("deptno"));
		Integer distCount = (Integer) cr.setMaxResults(1).uniqueResult();
		log.info("no. of departments i.e., distinctCount(deptno) : "
				+ distCount);
	}

	public static void sumSalary(Session s) {
		// creating a Criteria instance and setting a projection
		Criteria cr = s.createCriteria("Emp").setProjection(
				Projections.sum("sal"));
		Double sumSal = (Double) cr.setMaxResults(1).uniqueResult();
		log.info("sum of salary i.e., sum(deptno) : " + sumSal);
	}

	public static void maxSalary(Session s) {
		// creating a Criteria instance and setting a projection
		Criteria cr = s.createCriteria("Emp").setProjection(
				Projections.max("sal"));
		Double maxSal = (Double) cr.setMaxResults(1).uniqueResult();
		log.info("max of salary i.e., max(sal) : " + maxSal);
	}

	public static void minSalary(Session s) {
		// creating a Criteria instance and setting a projection
		Criteria cr = s.createCriteria("Emp").setProjection(
				Projections.avg("sal"));
		Double minSal = (Double) cr.setMaxResults(1).uniqueResult();
		log.info("minimum of salary i.e., min(sal) : " + minSal);
	}

	public static void main(String[] args) {

		// getting SessionFactory from HibernateUtilities.
		SessionFactory sf = HibernateUtilities.getSessionFactory();
		// open session factory using session factory
		Session s = sf.openSession();
		// invoking the eCount method for counting the employees
		eCount(s);
		// invoking the countDistinctDept method for counting the distinct
		// deptno
		countDistinctDept(s);
		// invoking the sumSalary method for the sum of the all the salaries
		sumSalary(s);
		// invoking the maxSalary method for maximum salary
		maxSalary(s);
		// invoking the minSalary method for minimum salary
		minSalary(s);
		// close session will release database connection
		s.close();
		// close session factory will release any resources held by hibernate
		sf.close();
	}
}
