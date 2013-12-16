package com.nbos.hb.service.projections;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

//all the methods of Projections class
public class ProjectionsMethods {

	public static void main(String[] args) {

		// getting a named logger
		Logger log = Logger.getLogger("hib");

		Projection rowCount = Projections.rowCount();
		log.info("rowCount : " + rowCount);

		Projection avgProj = Projections.avg("sal");
		log.info("avgProj : " + avgProj);

		Projection countProj = Projections.count("eid");
		log.info("countProj : " + countProj);

		Projection distCountProj = Projections.countDistinct("deptno");
		log.info("distCountProj : " + distCountProj);

		Projection maxProj = Projections.max("sal");
		log.info("maxProj : " + maxProj);

		Projection sumProj = Projections.sum("sal");
		log.info("sumProj : " + sumProj.toString());

		Projection groupProj = Projections.groupProperty("deptno");
		log.info("groupProj : " + groupProj);
		
		Projection aliasProj = Projections.alias(Projections.avg("sal"), "avgSal");
		log.info("groupProj : " + aliasProj);
		
		Projection distProj = Projections.distinct(Projections.count("deptno"));
		log.info("groupProj : " + distProj);
		
	}
}
