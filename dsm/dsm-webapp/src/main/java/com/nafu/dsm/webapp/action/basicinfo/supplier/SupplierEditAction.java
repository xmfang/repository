package com.nafu.dsm.webapp.action.basicinfo.supplier;

import java.util.HashSet;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.nafu.dsm.domain.ContactInfo;
import com.nafu.dsm.domain.Supplier;
import com.nafu.dsm.webapp.action.EditBasicAction;

/**
 * @author xmfang
 *
 */
public class SupplierEditAction extends EditBasicAction {
	
	private static final long serialVersionUID = -8539401747364285543L;

	private Supplier supplier;
	
	private List<ContactInfo> contactInfos;
	
	public String execute() {
		if (supplier.getId() != null) {
			supplier = Supplier.get(Supplier.class, supplier.getId());
		}
		return SUCCESS;
	}

	@Action(value = "/basicinfo/supplier/supplier-save",
			results = {@Result(name = "success", type = "redirect", location = "/basicinfo/supplier/supplier-view.action", params = {"supplier.id", "%{supplier.id}"})}
	)
	public String saveSupplier() {
		supplier.setContactInfos(new HashSet<ContactInfo>(contactInfos));
		application.saveEntity(supplier);
		return SUCCESS;
	}
	
	@Action(value = "/basicinfo/supplier/supplier-remove",
		results = {@Result(name = "success", type = "redirect", location = "/basicinfo/supplier/supplier-list.action")}
	)
	public String removeSupplier() {
		if (supplier.getId() > 0) {
			supplier = Supplier.get(Supplier.class, supplier.getId());
			application.removeEntity(supplier);
		}
		return SUCCESS;
	}
	
	//getters and setters

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<ContactInfo> getContactInfos() {
		return contactInfos;
	}

	public void setContactInfos(List<ContactInfo> contactInfos) {
		this.contactInfos = contactInfos;
	}

}
