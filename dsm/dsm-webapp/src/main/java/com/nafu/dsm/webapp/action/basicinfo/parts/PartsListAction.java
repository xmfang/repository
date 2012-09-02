/**
 * 
 */
package com.nafu.dsm.webapp.action.basicinfo.parts;

import java.util.List;

import com.nafu.dsm.domain.Parts;
import com.nafu.dsm.webapp.action.BasicAction;

/**
 * @author xmfang
 *
 */
public class PartsListAction extends BasicAction {
	
	private static final long serialVersionUID = 1604222978129642381L;

	private String partsCategory;
		
	public List<Parts> getPartses() {
		return Parts.findByCategory(partsCategory);
	}

	public String getPartsCategory() {
		return partsCategory;
	}

	public void setPartsCategory(String partsCategory) {
		this.partsCategory = partsCategory;
	}

}
