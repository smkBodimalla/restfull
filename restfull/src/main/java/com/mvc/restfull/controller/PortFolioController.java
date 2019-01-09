package com.mvc.restfull.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.restfull.entity.BalencedGrowth;
import com.mvc.restfull.entity.EquityAmount;
import com.mvc.restfull.entity.PortFolio;
import com.mvc.restfull.service.PortfolioService;

@RestController
public class PortFolioController {

	private static final Logger PFCLOGGER = LoggerFactory.getLogger(PortFolioController.class);
	@Autowired
	private PortfolioService service;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage() {

		return "home";
	}

	@RequestMapping(value = "/createPortFolio")
	public String createPortFolio() throws Exception {
		BalencedGrowth balencedGrowth = new BalencedGrowth(1234l, "bal growth", 234567.23);
		EquityAmount equityAmount = new EquityAmount(2432l, "tax", 23.3);
		PortFolio portFolio = new PortFolio(123345l, "bal growth", balencedGrowth, equityAmount);
		Long folio = service.createPortFolio(portFolio);
		PFCLOGGER.info("portfolio created" + folio);
		return "home";
	}

}
