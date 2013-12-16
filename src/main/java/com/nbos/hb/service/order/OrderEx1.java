package com.nbos.hb.service.order;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import com.nbos.hb.pojos.Employee;
import com.nbos.hb.util.HibernateUtilities;

//example for ordering the result of criteria
public class OrderEx1 {

	public static void main(String[] args) {

		// getting a named logger
		Logger log = Logger.getLogger("hib");

		// getting SessionFactory from HibernateUtilities.
		SessionFactory sf = HibernateUtilities.getSessionFactory();
		// open session factory using session factory
		Session s = sf.openSession();
		// creating a Criteria instance
		Criteria cr = s.createCriteria("Emp");
		// adding an order for the property on the criteria instance
		cr.addOrder(Order.desc("sal"));

		// using list method on criteria instance
		List l = cr.list();

		for (int i = 0; i < l.size(); i++) {
			Employee e = (Employee) l.get(i);
			log.info(e.getEid() + ", " + e.getEname() + ", " + e.getSal()
					+ ", " + e.getDeptno().getDno());
		}

		// close session will release database connection
		s.close();
		// close session factory will release any resources held by hibernate
		sf.close();
	}
}
