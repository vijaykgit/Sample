package com.nbos.hb.service.detached;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import com.nbos.hb.util.HibernateUtilities;

//basic example for DetachedCriteria
public class DetachedCriteriaEx1{

	public static void main(String[] args) {

		// getting a named logger
		Logger log = Logger.getLogger("hib");

		// getting SessionFactory from HibernateUtilities.
		SessionFactory sf = HibernateUtilities.getSessionFactory();
		// open session factory using session factory
		Session s = sf.openSession();
		// creating a Criteria instance
		DetachedCriteria dc = DetachedCriteria.forEntityName("Emp");
		dc.setProjection(Projections.avg("sal"));
		List l = dc.getExecutableCriteria(s).list();
		for (int i = 0; i < l.size(); i++) {
			log.info(l.get(i));
		}

		// close session will release database connection
		s.close();
		// close session factory will release any resources held by hibernate
		sf.close();
	}
}
