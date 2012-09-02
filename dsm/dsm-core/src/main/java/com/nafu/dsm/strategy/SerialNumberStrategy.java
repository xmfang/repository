/**
 * 
 */
package com.nafu.dsm.strategy;

/**
 * 编号策略接口
 * @author xmfang
 *
 */
public interface SerialNumberStrategy {

	/**
	 * 使用日期加数字的策略，根据指定编号生成新的编号
	 * @return
	 */
	public String generateSerialNumber(String previousSerialNumber);
	
}
