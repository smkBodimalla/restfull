package com.mvc.restfull.repository;

import java.util.List;

import org.hibernate.HibernateException;

import com.mvc.restfull.entity.BalencedGrowth;
import com.mvc.restfull.entity.EquityAmount;
import com.mvc.restfull.entity.PortFolio;

public interface PortFolioDao {

	public Long genratePortPolio(PortFolio folio) throws HibernateException;

	public Long generateEquityAmount(EquityAmount equityAmount) throws HibernateException;

	public Long registerBalencedGrouwth(BalencedGrowth balencedGrowth) throws HibernateException;

	public PortFolio getPortfolio(Long pfId) throws HibernateException;

	public List<PortFolio> getPortfolios() throws HibernateException;

}
