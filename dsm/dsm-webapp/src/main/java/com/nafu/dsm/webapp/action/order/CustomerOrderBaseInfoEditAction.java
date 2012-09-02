/**
 * 
 */
package com.nafu.dsm.webapp.action.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.nafu.dsm.domain.Color;
import com.nafu.dsm.domain.Craft;
import com.nafu.dsm.domain.CustomerOrder;
import com.nafu.dsm.domain.CustomerOrderStatus;
import com.nafu.dsm.domain.Dictionary;
import com.nafu.dsm.domain.DictionaryCategory;
import com.nafu.dsm.domain.DoorCategory;
import com.nafu.dsm.domain.Model;
import com.nafu.dsm.domain.Style;
import com.nafu.dsm.strategy.SerialNumberStrategy;
import com.nafu.dsm.webapp.action.EditBasicAction;

/**
 * @author xmfang
 *
 */
public class CustomerOrderBaseInfoEditAction extends EditBasicAction {
	
	private static final long serialVersionUID = 4129457015265077192L;
	
	@Inject
	private SerialNumberStrategy serialNumberStrategy;
	
	private long orderId;
	
	private CustomerOrder customerOrder;
	
	public CustomerOrderStatus[] getCustomerOrderStatuses() {
		return CustomerOrderStatus.values();
	}
		
	public List<Model> getModels() {
		return Model.findAll(Model.class);
	}
	
	public List<Style> getStyles() {
		return Style.findAll(Style.class);
	}
	
	public List<DoorCategory> getDoorCategories() {
		return DoorCategory.findAll(DoorCategory.class);
	}
	
	public List<Color> getColors(long doorCategoryId) {
		return Color.findByDoorCategory(DoorCategory.get(DoorCategory.class, doorCategoryId));
	}
	
	public Map<DoorCategory, List<Color>> getDoorCategoriesAndColors() {
		Map<DoorCategory, List<Color>> results = new HashMap<DoorCategory, List<Color>>();
		for (DoorCategory doorCategory : DoorCategory.findAll(DoorCategory.class)) {
			results.put(doorCategory, Color.findByDoorCategory(doorCategory));
		}
		return results;
	}
	
	public List<Dictionary> getCraftCategories() {
		return Dictionary.findByCategory(DictionaryCategory.CRAFT_CATEGORY);
	}
	
	public List<Craft> findCraftsByCategory(String category) {
		return Craft.findByCategory(category);
	}
	
	@Override
	public String execute() {
		if (orderId == 0) {
			customerOrder = CustomerOrder.getInstanceWithInitSerialNumber(serialNumberStrategy);
		} else {
			customerOrder = CustomerOrder.get(CustomerOrder.class, orderId);
		}
		return SUCCESS;
	}
	
	@Action(value = "/order/customer-order-base-info-save",
			results = {@Result(name = "success", type = "redirect", location = "/order/customer-order-list.action")}
	)
	public String saveCustomerOrderBaseInfo() {
		application.saveEntity(customerOrder);
		return SUCCESS;
	}
	
	@Action(value = "/order/customer-order-base-info-remove",
			results = {@Result(name = "success", type = "redirect", location = "/order/customer-order-list.action")}
	)
	public String removeCustomerOrderBaseInfo() {
		if (orderId != 0) {
			application.removeEntity(CustomerOrder.get(CustomerOrder.class, orderId));
		}
		return SUCCESS;
	}
	
	//getter and setter method

	public void setSerialNumberStrategy(SerialNumberStrategy serialNumberStrategy) {
		this.serialNumberStrategy = serialNumberStrategy;
	}
	
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}

}
