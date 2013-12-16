package com.nbos.hb.service.projections;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.nbos.hb.util.HibernateUtilities;

//
public class ProjectionsEx {

	public static void main(String[] args) {

		// getting a named logger
		Logger log = Logger.getLogger("hib");

		// getting SessionFactory from HibernateUtilities.
		SessionFactory sf = HibernateUtilities.getSessionFactory();
		// open session factory using session factory
		Session s = sf.openSession();
		// creating a Criteria instance
		Criteria cr = s.createCriteria("Emp", "empCount");
		// creating Projection instance using the static method rowCount() on
		// Projections
		Projection proj = Projections.min("deptno");
		log.info("row count projection : " + proj);
		// setting the Projection on the Criteria instance
		cr.setProjection(proj);
		// using list method on Criteria instance
		List l = cr.list();
		log.info("no.of results returned in list: " + l.size());
		for (int i = 0; i < l.size(); i++) {
			Integer count = (Integer) l.get(i);
			log.info("no. of records i.e., count(*) : " + count);
		}

		// close session will release database connection
		s.close();
		// close session factory will release any resources held by hibernate
		sf.close();
	}
}
