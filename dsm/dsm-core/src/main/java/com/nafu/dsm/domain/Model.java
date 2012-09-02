/**
 * 
 */
package com.nafu.dsm.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.dayatang.domain.QuerySettings;

/**
 * 型号
 * @author xmfang
 *
 */
@Entity
@Table(name = "models")
public class Model extends Goods {

	private static final long serialVersionUID = -7234631570979214224L;

	/*
	 * 供应商
	 */	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;
	
	/*
	 * 型号名称
	 */
	@Column(nullable = false)
	private String name;

	/*
	 * 单位
	 */
	private String unit;
	
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * 查找某个供应商的所有型号
	 * @param supplier
	 * @return
	 */
	public static List<Model> findBySupplier(Supplier supplier) {
		return getRepository().find(QuerySettings.create(Model.class).eq("supplier", supplier));
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Model)) {
			return false;
		}
		Model castOther = (Model) other;
		return new EqualsBuilder()
			.append(supplier, castOther.supplier)
			.append(name, castOther.name)
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
		.append(supplier)
		.append(name)
		.toHashCode();
	}

	@Override
	public String toString() {
		return supplier.getName() + ":" + name;
	}
	
}
