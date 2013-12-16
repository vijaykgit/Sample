package com.nbos.hb.service.criteria;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nbos.hb.pojos.Employee;
import com.nbos.hb.util.HibernateUtilities;

//example for uniqueResult method on Criteria
public class CriteriaUniqueResult {

	public static void main(String[] args) {

		// getting a named logger
		Logger log = Logger.getLogger("hib");

		// getting SessionFactory from HibernateUtilities.
		SessionFactory sf = HibernateUtilities.getSessionFactory();
		// open session factory using session factory
		Session s = sf.openSession();
		// creating a Criteria instance and adding a restriction
		Criteria cr = s.createCriteria("Emp");
		// setting the maximum number of results to be retrieved
		cr.setMaxResults(0);
		// getting the unique result from the Criteria
		Employee e = (Employee) cr.uniqueResult();
		log.info(e.getEid() + ", " + e.getEname() + ", " + e.getSal() + ", "
				+ e.getDeptno().getDno());

		// close session will release database connection
		s.close();
		// close session factory will release any resources held by hibernate
		sf.close();
	}
}
