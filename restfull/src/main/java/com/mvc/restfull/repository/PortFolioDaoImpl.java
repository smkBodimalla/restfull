package com.mvc.restfull.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.restfull.entity.BalencedGrowth;
import com.mvc.restfull.entity.EquityAmount;
import com.mvc.restfull.entity.PortFolio;

@Repository
public class PortFolioDaoImpl implements PortFolioDao {
	private static final Logger PFILOGGER = LoggerFactory.getLogger(PortFolioDaoImpl.class);
	@Autowired(required=true)
	private HibernateTemplate ht;

	@Override
	public Long genratePortPolio(PortFolio folio) throws HibernateException {
		PFILOGGER.info("portfoli is generated");
		Long portFolioId = (Long) ht.save(folio);
		System.out.println(portFolioId);
		return portFolioId;
	}

	@Override
	public Long generateEquityAmount(EquityAmount equityAmount) throws HibernateException {
		// TODO Auto-generated method stub
		PFILOGGER.info("equity amount is generated");
		Long equityAmount2 = (Long) ht.save(equityAmount);
		System.out.println(equityAmount2);
		return equityAmount2;
	}

	@Override
	public Long registerBalencedGrouwth(BalencedGrowth balencedGrowth) throws HibernateException {
		// TODO Auto-generated method stub

		Long growth = (Long) ht.save(balencedGrowth);
		return growth;
	}

	@Override
	public PortFolio getPortfolio(Long pfId) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PortFolio> getPortfolios() throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}
