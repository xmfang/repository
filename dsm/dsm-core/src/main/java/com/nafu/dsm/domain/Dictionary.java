package com.nafu.dsm.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.dayatang.domain.AbstractEntity;
import com.dayatang.domain.QuerySettings;

/**
 * 字典
 * @author xmfang 
 * 
 */
@Entity
@Table(name = "dictionaries")
public class Dictionary extends AbstractEntity {

	private static final long serialVersionUID = 593343752055599110L;

	@Column(name = "serial_number", nullable = false)
	private String serialNumber;
	
	@Column(name = "sort_order")
	private int sortOrder;

	@Enumerated(EnumType.STRING)
	private DictionaryCategory category;
	
	private String text;
		
	private String remark;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public DictionaryCategory getCategory() {
		return category;
	}

	public void setCategory(DictionaryCategory category) {
		this.category = category;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Dictionary() {
	}
	
	/**
	 * 查找相同字典类型的字典
	 * @param category
	 * @return
	 */
	public static List<Dictionary> findByCategory(DictionaryCategory category) {
		return getRepository().find(QuerySettings.create(Dictionary.class)
				.eq("category", category)
				.asc("sortOrder"));
	}	

	@Override
	public String toString() {
		return text;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Dictionary))
			return false;
		Dictionary castOther = (Dictionary) other;
		return new EqualsBuilder().append(serialNumber, castOther.serialNumber)
				.append(category, castOther.category).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(serialNumber)
				.append(category).toHashCode();
	}
	
}
