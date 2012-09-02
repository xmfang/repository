/**
 * 
 */
package com.nafu.dsm.strategy;

/**
 * 立面计算算法
 * @author xmfang
 *
 */
public class Solid implements MeasurementStrategy {
	private double width;
	
	private double height;
	
	private double thickness;
	
	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public Solid(double width, double height, double thickness) {
		this.width = width;
		this.height = height;
		this.thickness = thickness;
	}
	
	@Override
	public double calculateResult() {
		return (width * height) + ((width + (height * 2)) * thickness);
	}

}
