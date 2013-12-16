package com.nbos.hb.service.projections;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.nbos.hb.util.HibernateUtilities;

//using alias method of Projections
public class ProjectionAliasUsingAs {

	// getting a named logger
	static Logger log = Logger.getLogger("hib");

	public static void main(String[] args) {

		// getting SessionFactory from HibernateUtilities.
		SessionFactory sf = HibernateUtilities.getSessionFactory();
		// open session factory using session factory
		Session s = sf.openSession();
		// creating a Criteria instance and setting a projection
		Criteria cr = s.createCriteria("Emp");
		// setting a projection with alias
		cr.setProjection(Projections.alias(Projections.id(), "id"));
		// using the addOrder method on Criteria for sorting of the result
		cr.addOrder(Order.asc("id"));
		List l = cr.list();
		for (int i = 0; i < l.size(); i++) {
			log.info(l.get(i));
		}

		// close session will release database connection
		s.close();
		// close session factory will release any resources held by hibernate
		sf.close();
	}
}
