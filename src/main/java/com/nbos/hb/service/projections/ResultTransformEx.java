package com.nbos.hb.service.projections;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.nbos.hb.util.HibernateUtilities;

//using simple Projections rowCount() method 
public class ResultTransformEx {

	public static void main(String[] args) {

		// getting a named logger
		Logger log = Logger.getLogger("hib");

		// getting SessionFactory from HibernateUtilities.
		SessionFactory sf = HibernateUtilities.getSessionFactory();
		// open session factory using session factory
		Session s = sf.openSession();
		// creating a Criteria instance
		Criteria cr = s.createCriteria("Emp", "projEx");
		log.info("alias name of first Criteria cr : " + cr.getAlias());
		Projection proj = Projections.rowCount();
		log.info("projection : " + proj);
		cr.setProjection(proj);
		// using list method on Criteria instance
		List l = cr.list();
		log.info("no.of elements in list: " + l.size());
		for (int i = 0; i < l.size(); i++) {
			Integer count = (Integer) l.get(i);
			log.info("no. of records (count(*)) : " + count);
		}

		// close session will release database connection
		s.close();
		// close session factory will release any resources held by hibernate
		sf.close();
	}
}
