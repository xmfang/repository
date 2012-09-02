/**
 * 
 */
package com.nafu.dsm.webapp.action.admin.dictionary;

import java.util.List;

import com.nafu.dsm.domain.Dictionary;
import com.nafu.dsm.domain.DictionaryCategory;
import com.nafu.dsm.webapp.action.BasicAction;

/**
 * @author xmfang
 *
 */
public class DictionaryListAction extends BasicAction {

	private static final long serialVersionUID = 5724282897986435287L;

	private DictionaryCategory category;
	
	public List<Dictionary> getDictionaries() {
		return Dictionary.findByCategory(category);
	}
	
	public DictionaryCategory getCategory() {
		return category;
	}

	public void setCategory(DictionaryCategory category) {
		this.category = category;
	}
	
}
