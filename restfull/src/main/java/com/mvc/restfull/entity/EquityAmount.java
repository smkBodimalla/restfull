package com.mvc.restfull.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EquityAmount_PF")
public class EquityAmount {

	@Id
	@Column(name = "ea_id")
	@SequenceGenerator(name = "eqa_sq", sequenceName = "ea_sq_gen", initialValue = 100000, allocationSize = 100)
	@GeneratedValue(generator = "eqa_sq", strategy = GenerationType.SEQUENCE)
	private Long eaId;

	@Column
	private String eaType;
	@Column
	private double tsx_total_return;

	public EquityAmount() {
		// TODO Auto-generated constructor stub
	}

	public EquityAmount(Long eaId, String eaType, double tsx_total_return) {
		super();
		this.eaId = eaId;
		this.eaType = eaType;
		this.tsx_total_return = tsx_total_return;
	}

	public Long getEaId() {
		return eaId;
	}

	public void setEaId(Long eaId) {
		this.eaId = eaId;
	}

	public String getEaType() {
		return eaType;
	}

	public void setEaType(String eaType) {
		this.eaType = eaType;
	}

	public double getTsx_total_return() {
		return tsx_total_return;
	}

	public void setTsx_total_return(double tsx_total_return) {
		this.tsx_total_return = tsx_total_return;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eaId == null) ? 0 : eaId.hashCode());
		result = prime * result + ((eaType == null) ? 0 : eaType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tsx_total_return);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		EquityAmount other = (EquityAmount) obj;
		if (eaId == null) {
			if (other.eaId != null)
				return false;
		} else if (!eaId.equals(other.eaId))
			return false;
		if (eaType == null) {
			if (other.eaType != null)
				return false;
		} else if (!eaType.equals(other.eaType))
			return false;
		if (Double.doubleToLongBits(tsx_total_return) != Double.doubleToLongBits(other.tsx_total_return))
			return false;
		return true;
	}

}
