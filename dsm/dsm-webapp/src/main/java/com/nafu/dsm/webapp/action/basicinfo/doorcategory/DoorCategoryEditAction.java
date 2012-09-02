/**
 * 
 */
package com.nafu.dsm.webapp.action.basicinfo.doorcategory;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.nafu.dsm.domain.DoorCategory;
import com.nafu.dsm.webapp.action.EditBasicAction;

/**
 * @author xmfang
 *
 */
public class DoorCategoryEditAction extends EditBasicAction {

	private static final long serialVersionUID = -2504587042326585942L;

	private long doorCategoryId;
	
	private DoorCategory doorCategory;
	
	public String execute() {
		if (doorCategoryId != 0) {
			doorCategory = DoorCategory.get(DoorCategory.class, doorCategoryId);
		}
		return SUCCESS;
	}
	
	@Action(value = "/basicinfo/doorcategory/door-category-save",
			results = {@Result(name = "success", type = "redirect", location = "/basicinfo/doorcategory/door-category-list.action")}
	)
	public String saveDoorCategory() {
		application.saveEntity(doorCategory);
		return SUCCESS;
	}
	
	@Action(value = "/basicinfo/doorcategory/door-category-remove",
			results = {@Result(name = "success", type = "redirect", location = "/basicinfo/doorcategory/door-category-list.action")}
	)
	public String removeDoorCategory() {
		if (doorCategoryId != 0) {
			application.removeEntity(DoorCategory.get(DoorCategory.class, doorCategoryId));
		}
		return SUCCESS;
	}

	//getter and setter
	
	public long getDoorCategoryId() {
		return doorCategoryId;
	}

	public void setDoorCategoryId(long doorCategoryId) {
		this.doorCategoryId = doorCategoryId;
	}

	public DoorCategory getDoorCategory() {
		return doorCategory;
	}

	public void setDoorCategory(DoorCategory doorCategory) {
		this.doorCategory = doorCategory;
	}	
	
}
