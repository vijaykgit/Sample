package com.nbos.hb.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.nbos.hb.pojos.Employee;
import com.nbos.hb.util.HibernateUtilities;

public class CriteriaProjectionGroup {

	public static void main(String[] args) {

		// getting a named logger
		Logger log = Logger.getLogger("hib");

		// getting SessionFactory from HibernateUtilities.
		SessionFactory sf = HibernateUtilities.getSessionFactory();
		// open session factory using session factory. this is a one time step
		Session s = sf.openSession();
		log.info(Employee.class.getName());
		// creating a Query instance
		Criteria cr = s.createCriteria("Emp");
		cr.setProjection(Projections.max("sal"));
		log.info("list()");
		// using list method on query instance
		List l = cr.list();
		// hqlquery.setMaxResults(2);
		// Employee e = (Employee) hqlquery.uniqueResult();

		log.info("no.of records : " + l.size());
		/*
		 * Iterator iter = l.iterator(); while ( iter.hasNext() ) { Map map =
		 * (Map) iter.next(); Employee cat = (Employee)
		 * map.get(Criteria.ROOT_ALIAS); Employee kitten = (Employee)
		 * map.get("kt"); log.info(kitten.getEname()); }
		 */for (int i = 0; i < l.size(); i++) {
			Object[] r = (Object[]) l.get(i);
			Employee e = (Employee) r[0];
			// log.info(e);
			log.info(e.getEid() + ", " + e.getEname() + ", " + e.getSal());
		}

		// close session will release database connection
		s.close();
		// close session factory will release any resources held by hibernate
		sf.close();
	}
}