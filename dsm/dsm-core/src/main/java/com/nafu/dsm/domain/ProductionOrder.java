/**
 * 
 */
package com.nafu.dsm.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 生产订单
 * @author xmfang
 *
 */
@Entity
@DiscriminatorValue(value = "PRODUCTION")
public class ProductionOrder extends Order {
	
	private static final long serialVersionUID = -2894060358085693426L;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;
	
	/*
	 * 订单中的门
	 */
	@OneToMany(mappedBy = "productionOrder")
	private Set<Door> doors = new HashSet<Door>();
	
	@Enumerated(EnumType.STRING)
	private ProductionOrderStatus status;
	
	/*
	 * 是否出错
	 */
	private boolean malfunction = false;
	
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Set<Door> getDoors() {
		return doors;
	}

	public void setDoors(Set<Door> doors) {
		this.doors = doors;
	}

	public ProductionOrderStatus getStatus() {
		return status;
	}

	public void setStatus(ProductionOrderStatus status) {
		this.status = status;
	}

	public boolean isMalfunction() {
		return malfunction;
	}

	public void setMalfunction(boolean malfunction) {
		this.malfunction = malfunction;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof ProductionOrder)) {
			return false;
		}
		ProductionOrder castOther = (ProductionOrder) other;
		return new EqualsBuilder()
			.append(getSerialNumber(), castOther.getSerialNumber())
			.append(supplier, castOther.supplier)
			.append(getOrderDate(), castOther.getOrderDate())
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
		.append(getSerialNumber())
		.append(supplier)
		.append(getOrderDate())
		.toHashCode();
	}

	@Override
	public String toString() {
		return supplier + ":" + getOrderDate() + ":" + getSerialNumber();
	}

}
