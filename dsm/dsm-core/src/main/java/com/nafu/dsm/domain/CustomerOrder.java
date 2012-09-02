package com.nafu.dsm.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.dayatang.domain.QuerySettings;
import com.nafu.dsm.strategy.SerialNumberStrategy;

/**
 * 客户订单
 * @author xmfang
 *
 */
@Entity
@DiscriminatorValue(value = "CUSTOMER")
public class CustomerOrder extends Order {

	private static final long serialVersionUID = -6665780274886061715L;

	/*
	 * 客户名称
	 */
	private String customer;
	
	/*
	 * 客户电话
	 */
	@Column(name = "customer_tel")
	private String customerTel;
	
	/*
	 * 客户地址
	 */
	@Column(name = "customer_address")
	private String customerAddress;
	
	/*
	 * 订金
	 */
	@Column(name = "deposit_cent")
	private int depositCent;
	
	/*
	 * 订单中的门
	 */
	@OneToMany(mappedBy = "customerOrder")
	private Set<Door> doors = new HashSet<Door>();
	
	/*
	 * 订单状态
	 */
	@Enumerated(EnumType.STRING)
	private CustomerOrderStatus status;
		
	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCustomerTel() {
		return customerTel;
	}

	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public int getDepositCent() {
		return depositCent;
	}

	public void setDepositCent(int depositCent) {
		this.depositCent = depositCent;
	}

	public Set<Door> getDoors() {
		return doors;
	}

	public void setDoors(Set<Door> doors) {
		this.doors = doors;
	}

	public CustomerOrderStatus getStatus() {
		return status;
	}

	public void setStatus(CustomerOrderStatus status) {
		this.status = status;
	}

	private CustomerOrder() {
	}
	
	public static synchronized CustomerOrder getInstanceWithInitSerialNumber(SerialNumberStrategy serialNumberStrategy) {
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setSerialNumber(serialNumberStrategy.generateSerialNumber(getLastOrderNumberToday()));
		return customerOrder;
	}
	
	private static String getLastOrderNumberToday() {
		CustomerOrder order = getRepository().getSingleResult(QuerySettings.create(CustomerOrder.class)
				.eq("orderDate", new Date())
				.desc("serialNumber"));
		if (order == null) {
			return "";
		}
		return order.getSerialNumber();
	}
	
	/**
	 * 查找未完成的订单（当前活动中）
	 * @return
	 */
	public static List<CustomerOrder> findActive() {
		return getRepository().find(QuerySettings.create(CustomerOrder.class).isNull("finishDate"));
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof CustomerOrder)) {
			return false;
		}
		CustomerOrder castOther = (CustomerOrder) other;
		return new EqualsBuilder()
			.append(getSerialNumber(), castOther.getSerialNumber())
			.append(customer, castOther.customer)
			.append(getOrderDate(), castOther.getOrderDate())
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
		.append(getSerialNumber())
		.append(customer)
		.append(getOrderDate())
		.toHashCode();
	}

	@Override
	public String toString() {
		return customer + ":" + getOrderDate() + ":" + getSerialNumber();
	}

}
