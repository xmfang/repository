/**
 * 
 */
package com.nafu.dsm.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.dayatang.domain.AbstractEntity;

/**
 * 门的种类
 * @author xmfang
 *
 */
@Entity
@Table(name = "door_categories")
public class DoorCategory extends AbstractEntity {

	private static final long serialVersionUID = -7124960198768034691L;

	/*
	 * 种类名称
	 */
	@Column(unique = true, nullable = false)
	private String name;
	
	/*
	 * 标准尺寸（规格）
	 */
	@Embedded
	private StandarSize standarSize;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StandarSize getStandarSize() {
		return standarSize;
	}

	public void setStandarSize(StandarSize standarSize) {
		this.standarSize = standarSize;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof DoorCategory)) {
			return false;
		}
		DoorCategory castOther = (DoorCategory) other;
		return new EqualsBuilder()
			.append(name, castOther.name)
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
		.append(name)
		.toHashCode();
	}

	@Override
	public String toString() {
		return name;
	}

}
