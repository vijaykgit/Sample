package com.nbos.hb.service.projections;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.nbos.hb.pojos.Department;
import com.nbos.hb.util.HibernateUtilities;

//using groupProperty method of the Projections class
public class GroupProjectionWithAggregations {

	// getting a named logger
	static Logger log = Logger.getLogger("hib");

	public static void main(String[] args) {

		// getting SessionFactory from HibernateUtilities.
		SessionFactory sf = HibernateUtilities.getSessionFactory();
		// open session factory using session factory
		Session s = sf.openSession();
		// creating a Criteria instance
		Criteria cr = s.createCriteria("Emp");
		// creating a ProjectionList instance and adding the projections
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.rowCount());
		pl.add(Projections.sum("sal"));
		pl.add(Projections.max("sal"));
		pl.add(Projections.groupProperty("deptno"));
		// setting the projection on the criteria instance
		cr.setProjection(pl);

		List l = cr.list();
		for (int i = 0; i < l.size(); i++) {
			Object[] row = (Object[]) l.get(i);
			Integer avg = (Integer) row[0];
			Double sum = (Double) row[1];
			Double max = (Double) row[2];
			Department dept = (Department) row[3];
			log.info(avg + ", " + sum + ", " + max + ", " + dept.getDno());
		}

		// close session will release database connection
		s.close();
		// close session factory will release any resources held by hibernate
		sf.close();
	}
}
