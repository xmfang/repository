package com.nafu.dsm.webapp.action.basicinfo.style;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.nafu.dsm.domain.Craft;
import com.nafu.dsm.domain.Style;
import com.nafu.dsm.domain.Supplier;
import com.nafu.dsm.webapp.action.EditBasicAction;

/**
 * @author xmfang
 *
 */
public class StyleEditAction extends EditBasicAction {

	private static final long serialVersionUID = -4611333342058583336L;
	
	private long styleId;
	
	private long supplierId;
	
	private float price;
	
	private float cost;
	
	private Set<Craft> crafts;
	
	private Set<Long> craftIds;
	
	private Style style;
	
	public List<Craft> getAllCrafts() {
		return Craft.findAll(Craft.class);
	}
	
	public String execute() {
		if (styleId != 0) {
			style = Style.get(Style.class, styleId);
			price = transformToYuan(style.getPriceCent());
			cost = transformToYuan(style.getCostCent());
			if (style.getCraftForSelect() != null && !style.getCraftForSelect().isEmpty()) {
				craftIds = new HashSet<Long>();
				for (Craft craft : style.getCraftForSelect()) {
					craftIds.add(craft.getId());
				}
			}
		}
		return SUCCESS;
	}

	@Action("/basicinfo/style/style-save")
	public String saveStyle() {
		style.setSupplier(Supplier.get(Supplier.class, supplierId));
		style.setPriceCent(transformToCent(price));
		style.setCostCent(transformToCent(cost));
		
		if (craftIds != null && !craftIds.isEmpty()) {
			Set<Craft> selectedCrafts = new HashSet<Craft>();
			for (long craftId : craftIds) {
				selectedCrafts.add(Craft.get(Craft.class, craftId));
			}
			style.setCraftForSelect(selectedCrafts);		
		}
		application.saveEntity(style);
		return null;
	}
	
	@Action(value = "/basicinfo/style/style-remove",
		results = {@Result(name = "success", type = "redirect",
				location = "/basicinfo/style/style-list.action", params = {"supplierId", "%{style.supplier.id}"})}
	)
	public String removeStyle() {
		if (styleId != 0) {
			style = Style.get(Style.class, styleId);
			application.removeEntity(style);
		}
		return SUCCESS;
	}
	
	//getters and setters

	public float getPrice() {
		return price;
	}

	public long getStyleId() {
		return styleId;
	}

	public void setStyleId(long styleId) {
		this.styleId = styleId;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public Set<Craft> getCrafts() {
		return crafts;
	}

	public void setCrafts(Set<Craft> crafts) {
		this.crafts = crafts;
	}

	public Set<Long> getCraftIds() {
		return craftIds;
	}

	public void setCraftIds(Set<Long> craftIds) {
		this.craftIds = craftIds;
	}

}
