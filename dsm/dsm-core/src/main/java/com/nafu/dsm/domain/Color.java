/**
 * 
 */
package com.nafu.dsm.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.dayatang.domain.QuerySettings;

/**
 * 门的颜色
 * @author xmfang
 *
 */
@Entity
@Table(name = "color")
public class Color extends Goods {

	private static final long serialVersionUID = -8873097466267851405L;

	/*
	 * 颜色名称
	 */
	private String name;

	/*
	 * 门的种类
	 */
	@ManyToOne
	@JoinColumn(name = "door_category_id")
	private DoorCategory doorCategory;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DoorCategory getDoorCategory() {
		return doorCategory;
	}

	public void setDoorCategory(DoorCategory doorCategory) {
		this.doorCategory = doorCategory;
	}

	public static List<Color> findByDoorCategory(DoorCategory doorcategory) {
		return getRepository().find(QuerySettings.create(Color.class).eq("doorCategory", doorcategory));
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Color)) {
			return false;
		}
		Color castOther = (Color) other;
		return new EqualsBuilder()
			.append(name, castOther.name)
			.append(doorCategory, castOther.doorCategory)
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
			.append(name)
			.append(doorCategory)
			.toHashCode();
	}

	@Override
	public String toString() {
		return name;
	}
	
}
