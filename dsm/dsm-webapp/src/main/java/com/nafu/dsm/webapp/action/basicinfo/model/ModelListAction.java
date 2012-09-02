/**
 * 
 */
package com.nafu.dsm.webapp.action.basicinfo.model;

import java.util.List;

import com.nafu.dsm.domain.Model;
import com.nafu.dsm.domain.Supplier;
import com.nafu.dsm.webapp.action.BasicAction;

/**
 * @author xmfang
 *
 */
public class ModelListAction extends BasicAction {
	
	private static final long serialVersionUID = -7976149510418030413L;
	
	private long supplierId;
	
	public List<Model> getModels() {
		return Model.findBySupplier(Supplier.get(Supplier.class, supplierId));
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

}
