/**
 * 
 */
package com.nafu.dsm.webapp.action.order;

import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.nafu.dsm.domain.Color;
import com.nafu.dsm.domain.DoorCategory;
import com.nafu.dsm.webapp.action.BasicAction;

/**
 * @author xmfang
 *
 */
@ParentPackage("json")
@Result(type = "json", name = "success", params = {
	"includeProperties",
	"colors, colors\\[\\d+\\]\\.id, colors\\[\\d+\\]\\.name" })
public class GetDoorColors extends BasicAction {
	
	private static final long serialVersionUID = -8159165837319193076L;

	private long doorCategoryId;

	public void setDoorCategoryId(long doorCategoryId) {
		this.doorCategoryId = doorCategoryId;
	}
	
	public List<Color> getColors() {
		return Color.findByDoorCategory(DoorCategory.get(DoorCategory.class, doorCategoryId));
	}
	
}
