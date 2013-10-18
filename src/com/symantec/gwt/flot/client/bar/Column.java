package com.symantec.gwt.flot.client.bar;

import com.symantec.gwt.flot.client.ChartFragment;

public class Column implements ChartFragment {

	private double height;
	private int position;
	private double absoluteX;

	public Column(double height, double absoluteX) {
		super();
		this.height = height;
		this.absoluteX = absoluteX;
	}
	

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public double getAbsoluteX() {
		return absoluteX;
	}

	public void setAbsoluteX(double absoluteX) {
		this.absoluteX = absoluteX;
	}

	
}
