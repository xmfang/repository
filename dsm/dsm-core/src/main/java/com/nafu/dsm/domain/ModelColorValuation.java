/**
 * 
 */
package com.nafu.dsm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.dayatang.domain.AbstractEntity;

/**
 * 型号结合颜色的计价
 * @author xmfang
 *
 */
@Entity
@Table(name = "model_color_valuation")
public class ModelColorValuation extends AbstractEntity {

	private static final long serialVersionUID = 6610233729100009875L;

	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;
	
	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;
	
	@Column(name = "price_cent")
	private int priceCent;

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getPriceCent() {
		return priceCent;
	}

	public void setPriceCent(int priceCent) {
		this.priceCent = priceCent;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof ModelColorValuation)) {
			return false;
		}
		ModelColorValuation castOther = (ModelColorValuation) other;
		return new EqualsBuilder()
			.append(supplier, castOther.supplier)
			.append(model, castOther.model)
			.append(color, castOther.color)
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
		.append(supplier)
		.append(model)
		.append(color)
		.toHashCode();
	}

	@Override
	public String toString() {
		return supplier.getName() + ":" + model + ":" + color;
	}
	
}
