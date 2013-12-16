package com.nbos.hb.service.projections;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;

import com.nbos.hb.pojos.Employee;
import com.nbos.hb.util.HibernateUtilities;

//using Property class for adding Criterion or Restriction
public class CriterionUsingProperty {

	// getting a named logger
	static Logger log = Logger.getLogger("hib");

	public static void main(String[] args) {

		// getting SessionFactory from HibernateUtilities.
		SessionFactory sf = HibernateUtilities.getSessionFactory();
		// open session factory using session factory
		Session s = sf.openSession();
		// creating a Criteria instance and setting a projection
		Criteria cr = s.createCriteria("Emp");
		// adding a Restriction or Criterion using the Property class method
		ProjectionList pl = Projections.projectionList();
		pl.add(Property.forName("sal").avg());
		pl.add(Property.forName("sal").max());
		pl.add(Property.forName("deptno").group());
		cr.setProjection(pl);
		cr.add(Property.forName("deptno").between(10, 30));
		cr.addOrder(Order.desc("deptno"));
		List l = cr.list();
		for (int i = 0; i < l.size(); i++) {
			Object[] row = (Object[]) l.get(i);
			log.info(row[0] + ", " + row[1] + ", " + row[2]);
		}

		// close session will release database connection
		s.close();
		// close session factory will release any resources held by hibernate
		sf.close();
	}
}
