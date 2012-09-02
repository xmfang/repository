/**
 * 
 */
package com.nafu.dsm.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import com.dayatang.domain.ValueObject;

/**
 * 门的尺寸
 * @author xmfang
 *
 */
@Embeddable
public class DoorSize implements ValueObject {

	private static final long serialVersionUID = 6469572631979702601L;

	/*
	 * 铰位
	 */
	@Column(name = "fix_side")
	private String fixSide;
	
	/*
	 * 吊脚
	 */
	@Column(name = "diao_jiao_mm")
	private int diaoJiaomm;
	
	/*
	 * 包边位
	 */
	@Column(name = "edge_covering_side")
	private String edgeCoveringSide;
	
	/*
	 * 包框尺寸
	 */
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "widthmm", column = @Column(name = "wrap_round_width_mm")),
		@AttributeOverride(name = "heightmm", column = @Column(name = "wrap_round_height_mm")),
		@AttributeOverride(name = "thicknessmm", column = @Column(name = "wrap_round_thickness_mm"))		
	})
	private StandarSize wrapRoundSize;
	
	/*
	 * 包边尺寸
	 */
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "widthmm", column = @Column(name = "edge_covering_width_mm")),
		@AttributeOverride(name = "heightmm", column = @Column(name = "edge_covering_height_mm")),
		@AttributeOverride(name = "thicknessmm", column = @Column(name = "edge_covering_thickness_mm"))		
	})
	private StandarSize edgeCoveringSize;
	
	/*
	 * 见光尺寸
	 */
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "widthmm", column = @Column(name = "lighting_width_mm")),
		@AttributeOverride(name = "heightmm", column = @Column(name = "lighting_height_mm")),
		@AttributeOverride(name = "thicknessmm", column = @Column(name = "lighting_thickness_mm"))		
	})
	private StandarSize lightingSize;
	
	/*
	 * 门扇尺寸
	 */
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "widthmm", column = @Column(name = "door_leaf_width_mm")),
		@AttributeOverride(name = "heightmm", column = @Column(name = "door_leaf_height_mm")),
		@AttributeOverride(name = "thicknessmm", column = @Column(name = "door_leaf_thickness_mm"))		
	})
	private StandarSize doorLeafSize;

	/*
	 * 旧门扇尺寸
	 */
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "widthmm", column = @Column(name = "old_door_leaf_width_mm")),
		@AttributeOverride(name = "heightmm", column = @Column(name = "old_door_leaf_height_mm")),
		@AttributeOverride(name = "thicknessmm", column = @Column(name = "old_door_leaf_thickness_mm"))		
	})
	private StandarSize oldDoorLeafSize;
	
	public String getFixSide() {
		return fixSide;
	}

	public void setFixSide(String fixSide) {
		this.fixSide = fixSide;
	}

	public int getDiaoJiaomm() {
		return diaoJiaomm;
	}

	public void setDiaoJiaomm(int diaoJiaomm) {
		this.diaoJiaomm = diaoJiaomm;
	}

	public String getEdgeCoveringSide() {
		return edgeCoveringSide;
	}

	public void setEdgeCoveringSide(String edgeCoveringSide) {
		this.edgeCoveringSide = edgeCoveringSide;
	}

	public StandarSize getWrapRoundSize() {
		return wrapRoundSize;
	}

	public void setWrapRoundSize(StandarSize wrapRoundSize) {
		this.wrapRoundSize = wrapRoundSize;
	}

	public StandarSize getEdgeCoveringSize() {
		return edgeCoveringSize;
	}

	public void setEdgeCoveringSize(StandarSize edgeCoveringSize) {
		this.edgeCoveringSize = edgeCoveringSize;
	}

	public StandarSize getLightingSize() {
		return lightingSize;
	}

	public void setLightingSize(StandarSize lightingSize) {
		this.lightingSize = lightingSize;
	}

	public StandarSize getDoorLeafSize() {
		return doorLeafSize;
	}

	public void setDoorLeafSize(StandarSize doorLeafSize) {
		this.doorLeafSize = doorLeafSize;
	}

	public StandarSize getOldDoorLeafSize() {
		return oldDoorLeafSize;
	}

	public void setOldDoorLeafSize(StandarSize oldDoorLeafSize) {
		this.oldDoorLeafSize = oldDoorLeafSize;
	}	
	
}
