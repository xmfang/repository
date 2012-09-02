/**
 * 
 */
package com.nafu.dsm.webapp.action.basicinfo.doorcategory;

import java.util.List;

import com.nafu.dsm.domain.DoorCategory;
import com.nafu.dsm.webapp.action.BasicAction;

/**
 * @author xmfang
 *
 */
public class DoorCategoryListAction extends BasicAction {

	private static final long serialVersionUID = 1730287494255442200L;

	public List<DoorCategory> getDoorCategories() {
		return DoorCategory.findAll(DoorCategory.class);
	}
	
}
