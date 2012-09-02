/**
 * 
 */
package com.nafu.dsm.webapp.action.admin.dictionary;

import com.nafu.dsm.domain.DictionaryCategory;
import com.nafu.dsm.webapp.action.BasicAction;

/**
 * @author xmfang
 *
 */
public class DictionaryManage extends BasicAction {

	private static final long serialVersionUID = -271912531938425650L;

	public DictionaryCategory[] getCategories() {
		return DictionaryCategory.values();
	}
	
}
