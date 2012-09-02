/**
 * 
 */
package com.nafu.dsm.domain;

/**
 * 客户订单状态
 * @author xmfang
 *
 */
public enum CustomerOrderStatus {
	ORDER_WITH_NO_DEPOSIT,		//下单未付订金
	ORDER_WITH_DEPOSIT,			//下单已付订金
	MEASURE_SIZE,				//已量尺寸
	RESERVE_PRODUCTION,			//已下生产订单
	ARRIVALED,					//已到货
	DELIVERY_NO_INSTALL,		//已送货未安装 
	REPAIR_NO_PAYED,			//返修未付款
	REPAIR_PAYED,				//返修已付款
	INSTALLED_NO_PAYED,			//已安装未付款
	INSTALLED_PAYED,			//已安装已付款
	FINISH						//完成
}
