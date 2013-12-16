package com.nbos.hb.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;

import com.nbos.hb.pojos.Department;
import com.nbos.hb.pojos.Employee;
import com.nbos.hb.util.HibernateUtilities;

//using the createAlias method for one to many association
public class CriteriaAliasOnetoMany {

	public static void main(String[] args) {

		// getting a named logger
		Logger log = Logger.getLogger("hib");

		// getting SessionFactory from HibernateUtilities.
		SessionFactory sf = HibernateUtilities.getSessionFactory();
		// open session factory using session factory
		Session s = sf.openSession();
		// creating a Criteria instance
		Criteria cr = s.createCriteria("Dept");
		// using the createAlias method with join type
		cr.createAlias("emp", "e", CriteriaSpecification.LEFT_JOIN);

		log.info("list()");
		// using list method on Criteria instance
		List l = cr.list();

		log.info("no.of records : " + l.size());
		for (int i = 0; i < l.size(); i++) {
			Department d = (Department) l.get(i);
			Set<Employee> set = d.getEmp();
			Iterator<Employee> it = set.iterator();
			Employee e = null;
			while (it.hasNext()) {
				e = it.next();
				log.info(e.getEid() + ", " + e.getEname() + ", " + e.getSal()
						+ ", " + d.getDno() + ", " + d.getDname() + ", "
						+ d.getDloc());
			}
			
		}

		// close session will release database connection
		s.close();
		// close session factory will release any resources held by hibernate
		sf.close();
	}
}