package com.nafu.dsm.webapp.action.basicinfo.model;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.nafu.dsm.domain.Model;
import com.nafu.dsm.domain.Supplier;
import com.nafu.dsm.webapp.action.EditBasicAction;

/**
 * @author xmfang
 *
 */
public class ModelEditAction extends EditBasicAction {

	private static final long serialVersionUID = 577254244599118131L;
	
	private long modelId;
	
	private long supplierId;
	
	private float price;
	
	private float cost;
	
	private Model model;
	
	public String execute() {
		if (modelId != 0) {
			model = Model.get(Model.class, modelId);
			price = transformToYuan(model.getPriceCent());
			cost = transformToYuan(model.getCostCent());
		}
		return SUCCESS;
	}

	@Action("/basicinfo/model/model-save")
	public String saveModel() {
		model.setSupplier(Supplier.get(Supplier.class, supplierId));
		model.setPriceCent(transformToCent(price));
		model.setCostCent(transformToCent(cost));
		application.saveEntity(model);
		return null;
	}
	
	@Action(value = "/basicinfo/model/model-remove",
		results = {@Result(name = "success", type = "redirect",
				location = "/basicinfo/model/model-list.action", params = {"supplierId", "%{model.supplier.id}"})}
	)
	public String removeModel() {
		if (modelId != 0) {
			model = Model.get(Model.class, modelId);
			application.removeEntity(model);
		}
		return SUCCESS;
	}
	
	//getters and setters

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public long getModelId() {
		return modelId;
	}

	public void setModelId(long modelId) {
		this.modelId = modelId;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

}
