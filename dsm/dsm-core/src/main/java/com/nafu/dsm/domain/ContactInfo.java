/**
 * 
 */
package com.nafu.dsm.domain;

import javax.persistence.Embeddable;

import com.dayatang.domain.ValueObject;

/**
 * 供应商（厂家）联系信息
 * 
 * @author xmfang
 *
 */
@Embeddable
public class ContactInfo implements ValueObject {

	private static final long serialVersionUID = -5789452960610310713L;

	/*
	 * 联系人
	 */
	private String contacter;
	
	/*
	 * 职位
	 */
	private String title;
	
	/*
	 * 联系电话
	 */
	private String tel;

	/*
	 * 电子邮箱
	 */
	private String email;
	
	/*
	 * QQ号
	 */
	private String QQ;
	
	/*
	 * 备注
	 */
	private String remark;
	
	public String getContacter() {
		return contacter;
	}

	public void setContacter(String contacter) {
		this.contacter = contacter;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
