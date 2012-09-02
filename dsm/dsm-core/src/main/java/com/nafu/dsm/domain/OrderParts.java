/**
 * 
 */
package com.nafu.dsm.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dayatang.domain.ValueObject;

/**
 * 订单的配件订货
 * @author xmfang
 *
 */
@Embeddable
public class OrderParts implements ValueObject {

	private static final long serialVersionUID = 7129511447538134113L;

	/*
	 * 配件
	 */
	@ManyToOne
	@JoinColumn(name = "parts_id")
	private Parts parts;
	
	/*
	 * 数量
	 */
	private int count;

	/*
	 * 配件总价
	 */
	@Column(name = "total_price_cent")
	private int totalPriceCent;
	
	public Parts getParts() {
		return parts;
	}

	public void setParts(Parts parts) {
		this.parts = parts;
	}

	public int getCount() {
		return count;
	}

	public int getTotalPriceCent() {
		return totalPriceCent;
	}

	public void setTotalPriceCent(int totalPriceCent) {
		this.totalPriceCent = totalPriceCent;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
