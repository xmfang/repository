/**
 * 
 */
package com.nafu.dsm.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.dayatang.domain.QuerySettings;

/**
 * 款式
 * @author xmfang
 *
 */
@Entity
@Table(name = "styles")
public class Style extends Goods {

	private static final long serialVersionUID = 1658598663567838688L;

	/*
	 * 所属供应商
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;
	
	/*
	 * 款式编码
	 */
	private String code;
	
	/*
	 * 款式可选工艺
	 */
	@OneToMany
	@JoinTable(name = "style_crafts",
			joinColumns = @JoinColumn(name = "style_id"),
			inverseJoinColumns = @JoinColumn(name = "craft_id"))
	private Set<Craft> craftForSelect;

	/*
	 * 描述
	 */
	private String description;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<Craft> getCraftForSelect() {
		return craftForSelect;
	}

	public void setCraftForSelect(Set<Craft> craftForSelect) {
		this.craftForSelect = craftForSelect;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 查找某个供应商的所有款式
	 * @param supplier
	 * @return
	 */
	public static List<Style> findBySupplier(Supplier supplier) {
		return getRepository().find(QuerySettings.create(Style.class).eq("supplier", supplier));
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Style)) {
			return false;
		}
		Style castOther = (Style) other;
		return new EqualsBuilder()
			.append(supplier, castOther.supplier)
			.append(code, castOther.code)
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
		.append(supplier)
		.append(code)
		.toHashCode();
	}

	@Override
	public String toString() {
		return supplier.getName() + ":" + code;
	}
	
}
