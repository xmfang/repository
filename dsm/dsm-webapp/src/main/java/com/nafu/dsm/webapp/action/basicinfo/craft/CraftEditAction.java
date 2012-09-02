package com.nafu.dsm.webapp.action.basicinfo.craft;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.nafu.dsm.domain.Craft;
import com.nafu.dsm.webapp.action.EditBasicAction;

/**
 * @author xmfang
 *
 */
public class CraftEditAction extends EditBasicAction {

	private static final long serialVersionUID = -7359471638599676673L;
	
	private long craftId;
	
	private String craftCategory;
	
	private float price;
	
	private float cost;
	
	private Craft craft;
	
	public String execute() {
		if (craftId != 0) {
			craft = Craft.get(Craft.class, craftId);
			price = transformToYuan(craft.getPriceCent());
			cost = transformToYuan(craft.getCostCent());
		}
		return SUCCESS;
	}

	@Action("/basicinfo/craft/craft-save")
	public String saveCraft() {
		craft.setCategory(craftCategory);
		craft.setPriceCent(transformToCent(price));
		craft.setCostCent(transformToCent(cost));
		application.saveEntity(craft);
		return null;
	}
	
	@Action(value = "/basicinfo/craft/craft-remove",
		results = {@Result(name = "success", type = "redirect",
				location = "/basicinfo/craft/craft-list.action", params = {"craftCategory", "%{craft.category}"})}
	)
	public String removeCraft() {
		if (craftId != 0) {
			craft = Craft.get(Craft.class, craftId);
			application.removeEntity(craft);
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

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public long getCraftId() {
		return craftId;
	}

	public void setCraftId(long craftId) {
		this.craftId = craftId;
	}

	public String getCraftCategory() {
		return craftCategory;
	}

	public void setCraftCategory(String craftCategory) {
		this.craftCategory = craftCategory;
	}

	public Craft getCraft() {
		return craft;
	}

	public void setCraft(Craft craft) {
		this.craft = craft;
	}

}
