/**
 * 
 */
package com.nafu.dsm.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dayatang.domain.AbstractEntity;

/**
 * 订单抽象类
 * @author xmfang
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "CATEGORY")
@Table(name = "orders")
public abstract class Order extends AbstractEntity {

	private static final long serialVersionUID = -7471098728042769949L;
	
	/*
	 * 订单编号
	 */
	@Column(name = "serial_number", unique = true)
	private String serialNumber;

	/*
	 * 下单日期
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "order_date")
	private Date orderDate;
	
	/*
	 * 完成日期
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "finish_date")
	private Date finishDate;
	
	/*
	 * 总价
	 */
	@Column(name = "total_price")
	private int totalPrice;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	
}
