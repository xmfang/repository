/**
 * 
 */
package com.nafu.dsm.webapp.action.basicinfo.supplier;

import java.util.List;

import com.nafu.dsm.domain.Supplier;
import com.nafu.dsm.webapp.action.BasicAction;

/**
 * @author xmfang
 *
 */
public class SupplierListAction extends BasicAction {

	private static final long serialVersionUID = 4202781670563485295L;

	public List<Supplier> getSuppliers() {
		return Supplier.findCooperating();
	}
	
}
