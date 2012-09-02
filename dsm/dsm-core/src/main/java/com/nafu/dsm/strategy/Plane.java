/**
 * 
 */
package com.nafu.dsm.strategy;

/**
 * 平面计算算法
 * @author xmfang
 *
 */
public class Plane implements MeasurementStrategy {

	private double width;
	
	private double height;
	
	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public Plane(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double calculateResult() {
		return width * height;
	}

}
