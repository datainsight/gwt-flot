package com.symantec.gwt.flot.client.pie;

import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONValue;
import com.symantec.gwt.flot.client.Series;

public class PieSeries extends Series<Slice>
{
	private double absoluteValue;

	public PieSeries(double absoluteValue, int colorHex, String label)
	{
		super(colorHex, label);
		this.absoluteValue = absoluteValue;
	}

	@Override
	protected JSONValue getDataObject()
	{
		return new JSONNumber(absoluteValue);
	}

	public double getAbsoluteValue()
	{
		return absoluteValue;
	}

	public void setAbsoluteValue(double absoluteValue)
	{
		this.absoluteValue = absoluteValue;
	}

}
