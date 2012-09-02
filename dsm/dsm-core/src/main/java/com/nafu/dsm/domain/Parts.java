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
 * 门的配件，如锁，合页等。
 * @author xmfang
 *
 */
@Entity
@Table(name = "partses")
public class Parts extends Goods {

	private static final long serialVersionUID = 2635061422086780189L;

	/*
	 * 配件名称
	 */
	private String name;
	
	/*
	 * 配件类别，如锁，合页等
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

	public static List<Parts> findByCategory(String category) {
		return getRepository().find(QuerySettings.create(Parts.class).eq("category", category));
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Parts))
			return false;
		Parts castOther = (Parts) other;
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
