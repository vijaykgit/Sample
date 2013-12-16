package com.nbos.hb.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nbos.hb.pojos.Department;
import com.nbos.hb.pojos.Employee;
import com.nbos.hb.util.HibernateUtilities;

//using the createCriteria with alias method on Criteria instance
public class CreateCriteriaAssociationWithAlias {

	public static void main(String[] args) {

		// getting a named logger
		Logger log = Logger.getLogger("hib");

		// getting SessionFactory from HibernateUtilities.
		SessionFactory sf = HibernateUtilities.getSessionFactory();
		// open session factory using session factory
		Session s = sf.openSession();
		// creating a Criteria instance
		Criteria cr = s.createCriteria("Emp");
		// using the createCriteria with alias method on Criteria instance
		Criteria cr1 = cr.createCriteria("deptno","dept");
		log.info("first criteria - cr : " + cr.hashCode());
		log.info("second criteria - cr1 : " + cr1.hashCode());
		log.info("alias name of first criteria cr : " + cr.getAlias());
		log.info("alias name of second criteria cr1 : " + cr1.getAlias());
		// using list method on Criteria instance
		List l = cr.list();
	
		log.info("no.of records : " + l.size());
		for (int i = 0; i < l.size(); i++) {
			Employee e = (Employee) l.get(i);
			Department d = e.getDeptno();
			// log.info(e);
			log.info(e.getEid() + ", " + e.getEname() + ", " + e.getSal()
					+ ", " + d.getDno() + ", " + d.getDname() + ", "
					+ d.getDloc());
		}

		// close session will release database connection
		s.close();
		// close session factory will release any resources held by hibernate
		sf.close();
	}
}