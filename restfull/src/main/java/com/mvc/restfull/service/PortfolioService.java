package com.mvc.restfull.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.restfull.entity.BalencedGrowth;
import com.mvc.restfull.entity.EquityAmount;
import com.mvc.restfull.entity.PortFolio;
import com.mvc.restfull.repository.PortFolioDao;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PortfolioService {

	private static final Logger PFSLOGGER = LoggerFactory.getLogger(PortfolioService.class);

	@Autowired
	private PortFolioDao portFolioDao;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Long createPortFolio(PortFolio portFolio) throws Exception {
		PFSLOGGER.info("generateportfolio service ");
		return portFolioDao.genratePortPolio(portFolio);
	}

	public Long generateBalaGrowthService(BalencedGrowth balencedGrowth) {
		PFSLOGGER.info("genreate balgrowth service");
		return portFolioDao.registerBalencedGrouwth(balencedGrowth);
	}

	public Long generateEquityAmountService(EquityAmount equityAmount) {
		PFSLOGGER.info("genreate equity amount service ");
		return portFolioDao.generateEquityAmount(equityAmount);
	}

}
