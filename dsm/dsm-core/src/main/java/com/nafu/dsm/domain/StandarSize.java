/**
 * 
 */
package com.nafu.dsm.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.dayatang.domain.ValueObject;

/**
 * 标准尺寸
 * @author xmfang
 *
 */
@Embeddable
public class StandarSize implements ValueObject {

	private static final long serialVersionUID = 5942089307819025806L;

	/*
	 * 宽度(单位：毫米)
	 */
	@Column(name = "width_mm")
	private int widthmm;
	
	/*
	 * 高度(单位：毫米)
	 */
	@Column(name = "height_mm")
	private int heightmm;
	
	/*
	 * 厚度(单位：毫米)
	 */
	@Column(name = "thickness_mm")
	private int thicknessmm;

	public int getWidthmm() {
		return widthmm;
	}

	public void setWidthmm(int widthmm) {
		this.widthmm = widthmm;
	}

	public int getHeightmm() {
		return heightmm;
	}

	public void setHeightmm(int heightmm) {
		this.heightmm = heightmm;
	}

	public int getThicknessmm() {
		return thicknessmm;
	}

	public void setThicknessmm(int thicknessmm) {
		this.thicknessmm = thicknessmm;
	}

}
