/**
 * 
 */
package com.nafu.dsm.webapp.action.basicinfo.parts;

import java.util.ArrayList;
import java.util.List;

import com.nafu.dsm.domain.Dictionary;
import com.nafu.dsm.domain.DictionaryCategory;
import com.nafu.dsm.webapp.action.BasicAction;

/**
 * @author xmfang
 *
 */
public class PartsManage extends BasicAction {

	private static final long serialVersionUID = 5889830678859202801L;

	public List<String> getPartsCategories() {
		List<String> results = new ArrayList<String>();
		
		for (Dictionary craftCategory : Dictionary.findByCategory(DictionaryCategory.PARTS_CATEGORY)) {
			results.add(craftCategory.getText());
		}
		return results;
	}
	
}
