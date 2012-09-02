/**
 * 
 */
package com.nafu.dsm.webapp.action.basicinfo.color;

import java.util.List;

import com.nafu.dsm.domain.DoorCategory;
import com.nafu.dsm.webapp.action.BasicAction;

/**
 * @author xmfang
 *
 */
public class ColorManage extends BasicAction {

	private static final long serialVersionUID = 5524150038425686694L;

	public List<DoorCategory> getDoorCategories() {
		return DoorCategory.findAll(DoorCategory.class);
	}
	
}
