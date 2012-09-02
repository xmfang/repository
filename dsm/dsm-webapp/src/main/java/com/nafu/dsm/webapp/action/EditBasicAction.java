/**
 * 
 */
package com.nafu.dsm.webapp.action;

import javax.inject.Inject;

import com.nafu.dsm.application.DsmApplication;

/**
 * @author xmfang
 *
 */
public abstract class EditBasicAction extends BasicAction {

	private static final long serialVersionUID = 1400834477571135168L;
	
	@Inject
	protected DsmApplication application;

	public void setApplication(DsmApplication application) {
		this.application = application;
	}

}
