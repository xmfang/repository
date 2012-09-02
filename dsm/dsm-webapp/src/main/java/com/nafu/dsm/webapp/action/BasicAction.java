/**
 * 
 */
package com.nafu.dsm.webapp.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author xmfang
 *
 */
public abstract class BasicAction extends ActionSupport {
	
	private static final long serialVersionUID = 5226410407182005833L;

	public String getBasePath() {
		return ServletActionContext.getRequest().getContextPath();
	}
	
	public int transformToCent(final float yuan) {
		return (int) yuan * 100;
	}

	public float transformToYuan(final int cent) {
		return cent / 100;
	}
	
}
