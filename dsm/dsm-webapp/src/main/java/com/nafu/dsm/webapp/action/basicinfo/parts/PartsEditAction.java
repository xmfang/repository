package com.nafu.dsm.webapp.action.basicinfo.parts;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.nafu.dsm.domain.Parts;
import com.nafu.dsm.webapp.action.EditBasicAction;

/**
 * @author xmfang
 *
 */
public class PartsEditAction extends EditBasicAction {

	private static final long serialVersionUID = 7625810297000054159L;
	
	private long partsId;
	
	private String partsCategory;
	
	private float price;
	
	private float cost;
	
	private Parts parts;
	
	public String execute() {
		if (partsId != 0) {
			parts = Parts.get(Parts.class, partsId);
			price = transformToYuan(parts.getPriceCent());
			cost = transformToYuan(parts.getCostCent());
		}
		return SUCCESS;
	}

	@Action("/basicinfo/parts/parts-save")
	public String saveParts() {
		parts.setCategory(partsCategory);
		parts.setPriceCent(transformToCent(price));
		parts.setCostCent(transformToCent(cost));
		application.saveEntity(parts);
		return null;
	}
	
	@Action(value = "/basicinfo/parts/parts-remove",
		results = {@Result(name = "success", type = "redirect",
				location = "/basicinfo/parts/parts-list.action", params = {"partsCategory", "%{parts.category}"})}
	)
	public String removeParts() {
		if (partsId != 0) {
			parts = Parts.get(Parts.class, partsId);
			application.removeEntity(parts);
		}
		return SUCCESS;
	}
	
	//getters and setters

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public long getPartsId() {
		return partsId;
	}

	public void setPartsId(long partsId) {
		this.partsId = partsId;
	}

	public String getPartsCategory() {
		return partsCategory;
	}

	public void setPartsCategory(String partsCategory) {
		this.partsCategory = partsCategory;
	}

	public Parts getParts() {
		return parts;
	}

	public void setParts(Parts parts) {
		this.parts = parts;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

}
