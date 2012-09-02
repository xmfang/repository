/**
 * 
 */
package com.nafu.dsm.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * 
 * 门
 * @author xmfang
 *
 */
@Entity
@Table(name = "doors")
public class Door extends Goods {

	private static final long serialVersionUID = -7165552271887276596L;

	/*
	 * 客户订单（关联）
	 */
	@ManyToOne
	@JoinColumn(name = "customer_order_id")
	private CustomerOrder customerOrder;
	
	/*
	 * 生产订单（关联）
	 */
	@ManyToOne
	@JoinColumn(name = "production_order_id")
	private ProductionOrder productionOrder;
	
	/*
	 * 名称
	 */
	private String name;
	
	/*
	 * 门的类别
	 */
	@ManyToOne
	@JoinColumn(name = "door_category_id")
	private DoorCategory doorCategory;
	
	/*
	 * 供应商（厂家）
	 */
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;
	
	/*
	 * 型号
	 */
	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;
	
	/*
	 * 款式
	 */
	@ManyToOne
	@JoinColumn(name = "style_id")
	private Style style;
	
	/*
	 * 颜色
	 */
	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;
	
	/*
	 * 工艺
	 */
	@OneToMany
	@JoinTable(name = "door_crafts",
			joinColumns = @JoinColumn(name = "door_id"),
			inverseJoinColumns = @JoinColumn(name = "craft_id"))
	private Set<Craft> crafts = new HashSet<Craft>();
	
	/*
	 * 尺寸
	 */
	@Embedded
	private DoorSize doorSize;
	
	/*
	 * 配件
	 */
	@ElementCollection
	@CollectionTable(name = "door_partses", joinColumns = @JoinColumn(name = "door_id"))
	private Set<OrderParts> partses = new HashSet<OrderParts>();
	
	/*
	 * 其他加价项目
	 */
	@ElementCollection
	@CollectionTable(name = "other_add_price_items", joinColumns = @JoinColumn(name = "door_id"))
	@MapKeyColumn(name = "description")
	@Column(name = "price")
	private Map<String, Integer> otherAddPriceItems = new HashMap<String, Integer>();
	
	/*
	 * 数量
	 */
	private int count;
	
	/*
	 * 总价
	 */
	@Column(name = "total_price_cent")
	private int totalPriceCent;
	
	/*
	 * 备注
	 */
	@Column(length = 256)
	private String remark;
	
	@ManyToOne
	@JoinColumn(name = "inside_door_id")
	private Door insideDoor;
	
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}

	public ProductionOrder getProductionOrder() {
		return productionOrder;
	}

	public void setProductionOrder(ProductionOrder productionOrder) {
		this.productionOrder = productionOrder;
	}

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

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Set<Craft> getCrafts() {
		return crafts;
	}

	public void setCrafts(Set<Craft> crafts) {
		this.crafts = crafts;
	}

	public DoorSize getDoorSize() {
		return doorSize;
	}

	public void setDoorSize(DoorSize doorSize) {
		this.doorSize = doorSize;
	}

	public Set<OrderParts> getPartses() {
		return partses;
	}

	public void setPartses(Set<OrderParts> partses) {
		this.partses = partses;
	}

	public Map<String, Integer> getOtherAddPriceItems() {
		return otherAddPriceItems;
	}

	public void setOtherAddPriceItems(Map<String, Integer> otherAddPriceItems) {
		this.otherAddPriceItems = otherAddPriceItems;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalPriceCent() {
		return totalPriceCent;
	}

	public void setTotalPriceCent(int totalPriceCent) {
		this.totalPriceCent = totalPriceCent;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Door getInsideDoor() {
		return insideDoor;
	}

	public void setInsideDoor(Door insideDoor) {
		this.insideDoor = insideDoor;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Door)) {
			return false;
		}
		Door castOther = (Door) other;
		return new EqualsBuilder()
			.append(customerOrder, castOther.customerOrder)
			.append(doorCategory, castOther.doorCategory)
			.append(model, castOther.model)
			.append(style, castOther.style)
			.append(color, castOther.color)
			.append(crafts, castOther.crafts)
			.append(doorSize, castOther.doorSize)
			.append(getPriceCent(), castOther.getPriceCent())
			.append(count, castOther.count)
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
		.append(customerOrder)
		.append(doorCategory)
		.append(model)
		.append(style)
		.append(color)
		.append(crafts)
		.append(doorSize)
		.append(getPriceCent())
		.append(count)
		.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append(customerOrder)
		.append(doorCategory)
		.append(model)
		.append(style)
		.append(color)
		.append(crafts)
		.append(doorSize)
		.append(getPriceCent())
		.append(count)
		.toString();
	}
}
