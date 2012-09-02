package com.nafu.dsm.webapp.action.basicinfo.color;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.nafu.dsm.domain.Color;
import com.nafu.dsm.domain.DoorCategory;
import com.nafu.dsm.webapp.action.EditBasicAction;

/**
 * @author xmfang
 *
 */
public class ColorEditAction extends EditBasicAction {

	private static final long serialVersionUID = 6149933274161670315L;
	
	private long colorId;
	
	private long doorCategoryId;
	
	private float price;
	
	private float cost;
	
	private Color color;
	
	public String execute() {
		if (colorId != 0) {
			color = Color.get(Color.class, colorId);
			price = transformToYuan(color.getPriceCent());
			cost = transformToYuan(color.getCostCent());
		}
		return SUCCESS;
	}

	@Action("/basicinfo/color/color-save")
	public String saveColor() {
		color.setDoorCategory(DoorCategory.get(DoorCategory.class, doorCategoryId));
		color.setPriceCent(transformToCent(price));
		color.setCostCent(transformToCent(cost));
		application.saveEntity(color);
		return null;
	}
	
	@Action(value = "/basicinfo/color/color-remove",
		results = {@Result(name = "success", type = "redirect",
				location = "/basicinfo/color/color-list.action", params = {"doorCategoryId", "%{color.doorCategory.id}"})}
	)
	public String removeColor() {
		if (colorId != 0) {
			color = Color.get(Color.class, colorId);
			application.removeEntity(color);
		}
		return SUCCESS;
	}
	
	//getters and setters

	public long getColorId() {
		return colorId;
	}

	public void setColorId(long colorId) {
		this.colorId = colorId;
	}

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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public long getDoorCategoryId() {
		return doorCategoryId;
	}

	public void setDoorCategoryId(long doorCategoryId) {
		this.doorCategoryId = doorCategoryId;
	}

}
