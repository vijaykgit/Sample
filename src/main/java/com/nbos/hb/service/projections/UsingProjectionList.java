package com.nbos.hb.service.projections;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.nbos.hb.util.HibernateUtilities;

//using projectionList method of Projections
public class UsingProjectionList {

	// getting a named logger
	static Logger log = Logger.getLogger("hib");

	public static void main(String[] args) {

		// getting SessionFactory from HibernateUtilities.
		SessionFactory sf = HibernateUtilities.getSessionFactory();
		// open session factory using session factory
		Session s = sf.openSession();
		// creating a ProjectionList instance for adding multiple Projections
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.sum("sal"));
		pl.add(Projections.avg("sal"));
		pl.add(Projections.min("sal"));
		pl.add(Projections.max("sal"));
		// setting the ProjectionList instance on the Criteria instance
		Criteria cr = s.createCriteria("Emp")
				.setProjection(Projections.max("sal"))
				.setProjection(Projections.sum("sal"))
				.setProjection(Projections.avg("sal"))
				.setProjection(Projections.min("sal"));
		// getting the result
		List l = cr.list();

		Object[] row = (Object[]) l.get(0);
		log.info(row[0] + "," + row[1] + "," + row[2] + "," + row[3]);

		// close session will release database connection
		s.close();
		// close session factory will release any resources held by hibernate
		sf.close();
	}
}
