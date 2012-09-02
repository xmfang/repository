/**
 * 
 */
package com.nafu.dsm.webapp.action.basicinfo.supplier;

import com.nafu.dsm.domain.Supplier;
import com.nafu.dsm.webapp.action.BasicAction;

/**
 * @author xmfang
 *
 */
public class SupplierViewAction extends BasicAction {

	private static final long serialVersionUID = 3443263101193056566L;
	
	private Supplier supplier;

	public String execute() {
		supplier = Supplier.get(Supplier.class, supplier.getId());
		return SUCCESS;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
		
}
