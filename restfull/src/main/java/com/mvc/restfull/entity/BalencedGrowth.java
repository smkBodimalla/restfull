package com.mvc.restfull.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BalencedGrowth")
public class BalencedGrowth {

	@Id
	@Column(name = "bg_id")
	@SequenceGenerator(name = "bg_sq", sequenceName = "bg_sq_gen", initialValue = 10, allocationSize = 10)
	@GeneratedValue(generator = "bg_sq", strategy = GenerationType.SEQUENCE)
	private Long bgId;

	@Column
	private String bgModel;

	@Column
	private double balBenchMark;

	public BalencedGrowth() {
		// TODO Auto-generated constructor stub
	}

	public BalencedGrowth(Long bgId, String bgModel, double balBenchMark) {
		super();
		this.bgId = bgId;
		this.bgModel = bgModel;
		this.balBenchMark = balBenchMark;
	}

	public Long getBgId() {
		return bgId;
	}

	public void setBgId(Long bgId) {
		this.bgId = bgId;
	}

	public String getBgModel() {
		return bgModel;
	}

	public void setBgModel(String bgModel) {
		this.bgModel = bgModel;
	}

	public double getBalBenchMark() {
		return balBenchMark;
	}

	public void setBalBenchMark(double balBenchMark) {
		this.balBenchMark = balBenchMark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balBenchMark);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((bgId == null) ? 0 : bgId.hashCode());
		result = prime * result + ((bgModel == null) ? 0 : bgModel.hashCode());
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
		BalencedGrowth other = (BalencedGrowth) obj;
		if (Double.doubleToLongBits(balBenchMark) != Double.doubleToLongBits(other.balBenchMark))
			return false;
		if (bgId == null) {
			if (other.bgId != null)
				return false;
		} else if (!bgId.equals(other.bgId))
			return false;
		if (bgModel == null) {
			if (other.bgModel != null)
				return false;
		} else if (!bgModel.equals(other.bgModel))
			return false;
		return true;
	}

}
