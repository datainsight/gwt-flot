package com.symantec.gwt.flot.client.pie;

import com.symantec.gwt.flot.client.ChartFragment;

public class Slice implements ChartFragment {

	private float percentage;
	private double absoluteValue;
	
	public Slice(float percentage, double absoluteValue) {
		super();
		this.percentage = percentage;
		this.absoluteValue = absoluteValue;
	}

	public Slice(float percentage) {
		super();
		this.percentage = percentage;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public double getAbsoluteValue() {
		return absoluteValue;
	}

	public void setAbsoluteValue(double absoluteValue) {
		this.absoluteValue = absoluteValue;
	}
	
}
