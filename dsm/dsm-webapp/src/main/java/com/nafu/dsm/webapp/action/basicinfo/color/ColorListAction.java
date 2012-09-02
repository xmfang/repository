/**
 * 
 */
package com.nafu.dsm.webapp.action.basicinfo.color;

import java.util.List;

import com.nafu.dsm.domain.Color;
import com.nafu.dsm.domain.DoorCategory;
import com.nafu.dsm.webapp.action.BasicAction;

/**
 * @author xmfang
 *
 */
public class ColorListAction extends BasicAction {

	private static final long serialVersionUID = -5255633098534645097L;
	
	private long doorCategoryId;
	
	public List<Color> getColors() {
		return Color.findByDoorCategory(DoorCategory.get(DoorCategory.class, doorCategoryId));
	}

	public long getDoorCategoryId() {
		return doorCategoryId;
	}

	public void setDoorCategoryId(long doorCategoryId) {
		this.doorCategoryId = doorCategoryId;
	}


}
