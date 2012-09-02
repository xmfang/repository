/**
 * 
 */
package com.nafu.dsm.webapp.action.basicinfo.model;

import java.util.List;

import com.nafu.dsm.domain.Supplier;
import com.nafu.dsm.webapp.action.BasicAction;

/**
 * @author xmfang
 *
 */
public class ModelManage extends BasicAction {

	private static final long serialVersionUID = -4391688494027824545L;

	public List<Supplier> getSuppliers() {
		return Supplier.findAll(Supplier.class);
	}
	
}
