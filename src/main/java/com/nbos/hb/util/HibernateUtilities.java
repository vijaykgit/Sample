package com.nbos.hb.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//This class  provide the session factory
public class HibernateUtilities {

	public static SessionFactory getSessionFactory() {

		// create hibernate configuration
		Configuration cfg = new Configuration();
		// read configuration file: hibernate.cfg.xml
		cfg = cfg.configure();
		// create SessionFactory using configuration loaded
		SessionFactory sf = cfg.buildSessionFactory();
		//return session factory
		return sf;
	}

}
