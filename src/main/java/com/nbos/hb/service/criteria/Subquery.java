package com.nbos.hb.service.criteria;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.nbos.hb.pojos.Employee;
import com.nbos.hb.util.HibernateUtilities;

//example for setFirstResult method on Criteria
public class Subquery {

	public static void main(String[] args) {

		// getting a named logger
		Logger log = Logger.getLogger("hib");

		// getting SessionFactory from HibernateUtilities.
		SessionFactory sf = HibernateUtilities.getSessionFactory();
		// open session factory using session factory
		Session s = sf.openSession();

		DetachedCriteria avgSal = DetachedCriteria.forEntityName("Emp")
				.setProjection(Property.forName("sal").avg());

		log.info(avgSal.getExecutableCriteria(s).uniqueResult());

		// creating a Criteria instance and adding a restriction
		Criteria cr = s.createCriteria("Emp").add(
				Property.forName("sal").gt(avgSal));
		// using list method on criteria instance
		List l = cr.list();

		for(int i=0;i<l.size();i++){
			
		}
		
		// close session will release database connection
		s.close();
		// close session factory will release any resources held by hibernate
		sf.close();
	}
}
