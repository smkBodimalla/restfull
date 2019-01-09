package com.mvc.restfull.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "portFolioData")
public class PortFolio {

	@Id
	@Column(name = "pfId")
	@SequenceGenerator(name = "portfolio_sq", sequenceName = "portfolio_sq_gen", initialValue = 100, allocationSize = 10)
	@GeneratedValue(generator = "portfolio_sq", strategy = GenerationType.SEQUENCE)
	private Long pfId;

	@Column
	private String pfName;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = BalencedGrowth.class)
	@JoinColumn(name = "pf_bg_fk", referencedColumnName = "bg_id")
	private BalencedGrowth pfBalace;

	@OneToOne(targetEntity = EquityAmount.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "pf_eq_fk", referencedColumnName = "ea_id")
	private EquityAmount equityAmount;

	public PortFolio() {
		// TODO Auto-generated constructor stub
	}

	public PortFolio(Long pfId, String pfName, BalencedGrowth pfBalace, EquityAmount equityAmount) {
		super();
		this.pfId = pfId;
		this.pfName = pfName;
		this.pfBalace = pfBalace;
		this.equityAmount = equityAmount;
	}

	public Long getPfId() {
		return pfId;
	}

	public void setPfId(Long pfId) {
		this.pfId = pfId;
	}

	public String getPfName() {
		return pfName;
	}

	public void setPfName(String pfName) {
		this.pfName = pfName;
	}

	public BalencedGrowth getPfBalace() {
		return pfBalace;
	}

	public void setPfBalace(BalencedGrowth pfBalace) {
		this.pfBalace = pfBalace;
	}

	public EquityAmount getEquityAmount() {
		return equityAmount;
	}

	public void setEquityAmount(EquityAmount equityAmount) {
		this.equityAmount = equityAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((equityAmount == null) ? 0 : equityAmount.hashCode());
		result = prime * result + ((pfBalace == null) ? 0 : pfBalace.hashCode());
		result = prime * result + ((pfId == null) ? 0 : pfId.hashCode());
		result = prime * result + ((pfName == null) ? 0 : pfName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PortFolio other = (PortFolio) obj;
		if (equityAmount == null) {
			if (other.equityAmount != null)
				return false;
		} else if (!equityAmount.equals(other.equityAmount))
			return false;
		if (pfBalace == null) {
			if (other.pfBalace != null)
				return false;
		} else if (!pfBalace.equals(other.pfBalace))
			return false;
		if (pfId == null) {
			if (other.pfId != null)
				return false;
		} else if (!pfId.equals(other.pfId))
			return false;
		if (pfName == null) {
			if (other.pfName != null)
				return false;
		} else if (!pfName.equals(other.pfName))
			return false;
		return true;
	}

}
