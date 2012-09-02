/**
 * 
 */
package com.nafu.dsm.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.dayatang.domain.QuerySettings;

/**
 * 门的工艺
 * @author xmfang
 *
 */
@Entity
@Table(name = "crafts")
public class Craft extends Goods {

	private static final long serialVersionUID = 6797747900153511989L;

	/*
	 * 工艺名称
	 */
	private String name;
	
	/*
	 * 工艺类别，如包边工艺，玻璃工艺，油漆工艺等
	 */
	private String category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public static List<Craft> findByCategory(String category) {
		return getRepository().find(QuerySettings.create(Craft.class).eq("category",category));
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Craft))
			return false;
		Craft castOther = (Craft) other;
		return new EqualsBuilder().append(name, castOther.name)
				.append(category, castOther.category).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(name)
				.append(category).toHashCode();
	}

	@Override
	public String toString() {
		return category + ":" + name;
	}
	
}
