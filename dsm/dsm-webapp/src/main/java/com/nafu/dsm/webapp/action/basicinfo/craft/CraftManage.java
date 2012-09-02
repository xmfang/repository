/**
 * 
 */
package com.nafu.dsm.webapp.action.basicinfo.craft;

import java.util.ArrayList;
import java.util.List;

import com.nafu.dsm.domain.Dictionary;
import com.nafu.dsm.domain.DictionaryCategory;
import com.nafu.dsm.webapp.action.BasicAction;

/**
 * @author xmfang
 *
 */
public class CraftManage extends BasicAction {

	private static final long serialVersionUID = -6253078974262119867L;

	public List<String> getCraftCategories() {
		List<String> results = new ArrayList<String>();
		
		for (Dictionary craftCategory : Dictionary.findByCategory(DictionaryCategory.CRAFT_CATEGORY)) {
			results.add(craftCategory.getText());
		}
		return results;
	}
	
}
