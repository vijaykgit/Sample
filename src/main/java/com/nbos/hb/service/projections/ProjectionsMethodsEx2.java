package com.nbos.hb.service.projections;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.nbos.hb.util.HibernateUtilities;

//using the different methods of Projections
public class ProjectionsMethodsEx2 {

	// getting a named logger
	static Logger log = Logger.getLogger("hib");

	public static void propertyProjection(Session s) {
		// creating a Criteria instance and setting a projection
		Criteria cr = s.createCriteria("Emp").setProjection(
				Projections.property("ename"));
		List l = cr.list();
		for (int i = 0; i < l.size(); i++) {
			log.info(l.get(i));
		}
	}

	public static void idProjection(Session s) {
		// creating a Criteria instance and setting a projection
		Criteria cr = s.createCriteria("Emp").setProjection(Projections.id());
		List l = cr.list();
		for (int i = 0; i < l.size(); i++) {
			log.info(l.get(i));
		}
	}

	public static void main(String[] args) {

		// getting SessionFactory from HibernateUtilities.
		SessionFactory sf = HibernateUtilities.getSessionFactory();
		// open session factory using session factory
		Session s = sf.openSession();
		// invoking the propertyProjection method to return all the values of
		// the given property
		propertyProjection(s);
		// invoking the idProjection method to return all the values of the
		// identifier property
		idProjection(s);
		// close session will release database connection
		s.close();
		// close session factory will release any resources held by hibernate
		sf.close();
	}
}
