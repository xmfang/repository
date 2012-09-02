package com.nafu.dsm.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.dayatang.domain.AbstractEntity;
import com.dayatang.domain.QuerySettings;

/**
 * 供应商(厂家)
 * @author xmfang 
 * 
 */
@Entity
@Table(name = "suppliers")
public class Supplier extends AbstractEntity {

	private static final long serialVersionUID = -7325811105228127603L;

	/*
	 * 供应商名称
	 */
	private String name;
	
	/*
	 * 供应商电话
	 */
	private String tel;
	
	/*
	 * 供应商传真
	 */
	private String fax;
	
	/*
	 * 供应商地址
	 */
	private String address;
	
	/*
	 * 供应商网址
	 */
	private String website;
	
	/*
	 * 联系信息
	 */
	@ElementCollection
	@CollectionTable(name = "supplier_contact_infos", joinColumns = @JoinColumn(name = "supplier_id"))
	private Set<ContactInfo> contactInfos = new HashSet<ContactInfo>();
	
	/*
	 * 是不是合作中的供应商
	 */
	@Column(name = "active_partner")
	private boolean activePartner = true;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Set<ContactInfo> getContactInfos() {
		return contactInfos;
	}

	public void setContactInfos(Set<ContactInfo> contactInfos) {
		this.contactInfos = contactInfos;
	}

	public boolean isActivePartner() {
		return activePartner;
	}

	public void setActivePartner(boolean activePartner) {
		this.activePartner = activePartner;
	}

	/**
	 * 查找合作中的供应商
	 */
	public static List<Supplier> findCooperating() {
		return getRepository().find(QuerySettings.create(Supplier.class)
				.eq("activePartner", true));
	}

	/**
	 * 查找合作过的供应商
	 */
	public static List<Supplier> findCooperated() {
		return getRepository().find(QuerySettings.create(Supplier.class)
				.eq("activePartner", false));
	}
	
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Supplier))
			return false;
		Supplier castOther = (Supplier) other;
		return new EqualsBuilder()
				.append(name, castOther.name)
				.append(tel, castOther.tel)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(name)
				.append(tel)
				.toHashCode();
	}

	@Override
	public String toString() {
		return name;
	}

}
