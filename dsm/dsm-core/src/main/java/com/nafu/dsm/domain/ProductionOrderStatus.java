/**
 * 
 */
package com.nafu.dsm.domain;

/**
 * 生产订单状态
 * @author xmfang
 *
 */
public enum ProductionOrderStatus {
	ORDER_NO_FEEDBACK,		//下单未反馈
	ORDER_FEEDBACK,			//下单已反馈
	PRODUCING,				//生产中
	ARRIVALED,				//已到货
	REPAIR_NO_INSTALL,		//送货未安装
	REPAIR,					//返修已付款
	INSTALLED,				//已安装未付款
	FINISH					//完成
}
