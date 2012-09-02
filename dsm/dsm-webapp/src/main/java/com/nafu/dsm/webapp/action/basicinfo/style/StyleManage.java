/**
 * 
 */
package com.nafu.dsm.webapp.action.basicinfo.style;

import java.util.List;

import com.nafu.dsm.domain.Supplier;
import com.nafu.dsm.webapp.action.BasicAction;

/**
 * @author xmfang
 *
 */
public class StyleManage extends BasicAction {

	private static final long serialVersionUID = -7337441040331652203L;

	public List<Supplier> getSuppliers() {
		return Supplier.findAll(Supplier.class);
	}
	
}
