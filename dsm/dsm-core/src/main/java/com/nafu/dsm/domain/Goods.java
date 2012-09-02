package com.nafu.dsm.domain;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import com.dayatang.domain.AbstractEntity;

/**
 * @author xmfang
 *
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)     
public abstract class Goods extends AbstractEntity {
	
	private static final long serialVersionUID = -3838186848102464160L;
	
	/*
	 * 销售价格
	 */
	@Column(name = "price_cent")
	private int priceCent;

	/*
	 * 成本
	 */
	@Column(name = "cost_cent")
	private int costCent;
	
	public int getPriceCent() {
		return priceCent;
	}

	public void setPriceCent(int priceCent) {
		this.priceCent = priceCent;
	}

	public int getCostCent() {
		return costCent;
	}

	public void setCostCent(int costCent) {
		this.costCent = costCent;
	}
	
}
