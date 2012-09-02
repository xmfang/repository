/**
 * 
 */
package com.nafu.dsm.webapp.action.basicinfo.style;

import java.util.List;

import com.nafu.dsm.domain.Style;
import com.nafu.dsm.domain.Supplier;
import com.nafu.dsm.webapp.action.BasicAction;

/**
 * @author xmfang
 *
 */
public class StyleListAction extends BasicAction {
		
	private static final long serialVersionUID = 6452026740896568162L;
	
	private long supplierId;
	
	public List<Style> getStyles() {
		return Style.findBySupplier(Supplier.get(Supplier.class, supplierId));
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

}
