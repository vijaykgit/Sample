package com.nbos.hb.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nbos.hb.pojos.Department;
import com.nbos.hb.pojos.Employee;
import com.nbos.hb.util.HibernateUtilities;

//example using simple Criteria with setFetchMode method
public class SetFetchMode {

	public static void main(String[] args) {

		// getting a named logger
		Logger log = Logger.getLogger("hib");

		// getting SessionFactory from HibernateUtilities.
		SessionFactory sf = HibernateUtilities.getSessionFactory();
		// open session factory using session factory. this is a one time step
		Session s = sf.openSession();
		// creating a Criteria instance
		Criteria cr = s.createCriteria("Emp");
	//	cr.createCriteria("deptno");
	//	cr.setFetchMode("deptno", FetchMode.JOIN);
		// using list method on criteria instance
		List l = cr.list();

		log.info("no.of records : " + l.size());

		for (int i = 0; i < l.size(); i++) {
			Employee e = (Employee) l.get(i);
			Department d = (Department)e.getDeptno();
			log.info(e.getEid() + ", " + e.getEname() + ", " + e.getSal()
					+ ", " + d.getDno()+", "+d.getDname());
		}

		// close session will release database connection
		s.close();
		// close session factory will release any resources held by hibernate
		sf.close();
	}
}