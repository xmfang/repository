/**
 * 
 */
package com.nafu.dsm.webapp.action.order;

import java.util.List;

import com.nafu.dsm.domain.CustomerOrder;
import com.nafu.dsm.webapp.action.BasicAction;

/**
 * @author xmfang
 *
 */
public class CustomerOrderListAction extends BasicAction {

	private static final long serialVersionUID = 2827897556887327679L;

	public List<CustomerOrder> getCustomerOrders() {
		return CustomerOrder.findActive();
	}
	
}
