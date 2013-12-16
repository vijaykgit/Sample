package com.nbos.hb.service.projections;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.nbos.hb.pojos.Department;
import com.nbos.hb.util.HibernateUtilities;

//using groupProjection method of the Projections class
public class SimpleGroupProjection {

	// getting a named logger
	static Logger log = Logger.getLogger("hib");

	public static void main(String[] args) {

		// getting SessionFactory from HibernateUtilities.
		SessionFactory sf = HibernateUtilities.getSessionFactory();
		// open session factory using session factory
		Session s = sf.openSession();
		// creating a Criteria instance and setting a projection
		Criteria cr = s.createCriteria("Emp");
		// setting the group projection
		cr.setProjection(Projections.groupProperty("deptno"));

		List l = cr.list();
		for (int i = 0; i < l.size(); i++) {
			Department d = (Department) l.get(i);
			log.info(d.getDno());
		}

		// close session will release database connection
		s.close();
		// close session factory will release any resources held by hibernate
		sf.close();
	}
}
