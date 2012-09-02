/**
 * 
 */
package com.nafu.dsm.webapp.action.basicinfo.craft;

import java.util.List;

import com.nafu.dsm.domain.Craft;
import com.nafu.dsm.webapp.action.BasicAction;

/**
 * @author xmfang
 *
 */
public class CraftListAction extends BasicAction {
	
	private static final long serialVersionUID = 7740094519789629483L;
	
	private String craftCategory;
		
	public List<Craft> getCrafts() {
		return Craft.findByCategory(craftCategory);
	}

	public String getCraftCategory() {
		return craftCategory;
	}

	public void setCraftCategory(String craftCategory) {
		this.craftCategory = craftCategory;
	}

}
