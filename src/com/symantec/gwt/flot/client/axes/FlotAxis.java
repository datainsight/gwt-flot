package com.symantec.gwt.flot.client.axes;

import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.symantec.gwt.flot.client.TickUnit;

public abstract class FlotAxis {
	public static interface TickFormatter {
		String format(double value);
	}

	public enum Scale {
		LINEAR, LOGARITHMIC
	}

	private TickFormatter formatter;
	private JavaScriptObject __formatter__;

	private JavaScriptObject __transform__;
	private JavaScriptObject __inverseTransform__;

	private Scale scale;
	private Double minValue;
	private Double maxValue;
	
	
	private Integer decimalPrecision;
	private Map<Integer, String> axisMapping;
	private boolean isTimeAxis;
	private String timeFormat;
	private TickUnit minTickUnit = TickUnit.HOUR;
	private int minTickLength;
	
	public int getDecimalPrecision() {
		return decimalPrecision;
	}

	public void setDecimalPrecision(int decimalPrecision) {
		this.decimalPrecision = decimalPrecision;
	}

	public TickFormatter getFormatter() {
		return formatter;
	}

	public void setFormatter(TickFormatter formatter) {
		this.formatter = formatter;
		if (formatter != null) {
			__initFormatter__();
		}
	}

	public Scale getScale() {
		return scale;
	}

	public void setScale(Scale scale) {
		this.scale = scale;
		if (scale != null) {
			__initTransformers__();
		}
	}

	public String getTimeFormat()
	{
		return timeFormat;
	}
	public void setTimeFormat(String timeFormat)
	{
		this.timeFormat = timeFormat;
	}
	
	public TickUnit getMinTickUnit()
	{
		return minTickUnit;
	}
	public void setMinTickUnit(TickUnit minTickUnit)
	{
		this.minTickUnit = minTickUnit;
	}
	public int getMinTickLength()
	{
		return minTickLength;
	}
	public void setMinTickLength(int minTickLength)
	{
		this.minTickLength = minTickLength;
	}
	

	public Map<Integer, String> getAxisMapping() {
		return axisMapping;
	}

	public void setAxisMapping(Map<Integer, String> axisMapping) {
		this.axisMapping = axisMapping;
	}

	public JSONObject asJson() {
		JSONObject obj = new JSONObject();
		if (minValue != null) {
			obj.put("min", new JSONNumber(minValue));
		}
		if (maxValue != null) {
			obj.put("max", new JSONNumber(maxValue));
		}
		if (decimalPrecision != null) {
			obj.put("tickDecimals", new JSONNumber(decimalPrecision));
		}
		if(isTimeAxis)
		{
			obj.put("mode", new JSONString("time"));
			obj.put("timeformat", new JSONString(timeFormat));
			JSONArray minTickSize = new JSONArray();
			minTickSize.set(0, new JSONNumber(minTickLength));
			minTickSize.set(1, new JSONString(this.minTickUnit.asString()));
			obj.put("minTickSize", minTickSize);
		}
		else
		{
			obj.put("minTickSize", new JSONNumber(minTickLength));
		}
		if(axisMapping != null)
		{
			JSONArray ticks = new JSONArray();
			
			int i = 0;
			for(Integer k : axisMapping.keySet())
			{
				JSONArray t = new JSONArray();
				t.set(0, new JSONNumber(k));
				t.set(1, new JSONString(axisMapping.get(k)));
				ticks.set(i++, t);
			}
			
			obj.put("ticks", ticks);
			
		}
		if (__formatter__ != null) {
			JSONObject formatterFuncObj = new JSONObject(__formatter__);
			obj.put("tickFormatter", formatterFuncObj);
		}
		
		if (__transform__ != null && __inverseTransform__ != null) {
			
			JSONObject transformObj = new JSONObject(__transform__);
			JSONObject inverseTransformObj = new JSONObject(__inverseTransform__);
			obj.put("transform", transformObj);
			obj.put("inverseTransform", inverseTransformObj);
		}
		return obj;

	}

	private native void __initFormatter__()/*-{

		var self = this, myFormatter = self.@com.symantec.gwt.flot.client.axes.FlotAxis::formatter;
		self.@com.symantec.gwt.flot.client.axes.FlotAxis::__formatter__ = function(
				val, axis) {

			return myFormatter.@com.symantec.gwt.flot.client.axes.FlotAxis.TickFormatter::format(D)(val);
		};

	}-*/;

	private native void __initTransformers__()/*-{

		var self = this, myScale = self.@com.symantec.gwt.flot.client.axes.FlotAxis::scale;

		if (myScale == @com.symantec.gwt.flot.client.axes.FlotAxis.Scale::LOGARITHMIC) {
			self.@com.symantec.gwt.flot.client.axes.FlotAxis::__transform__ = function(v) {
				return Math.log(v);
			};
			
			self.@com.symantec.gwt.flot.client.axes.FlotAxis::__inverseTransform__ = function(v) {
				return Math.exp(v);
			};
		}

	}-*/;

	public boolean isTimeAxis() {
		return isTimeAxis;
	}

	public void setTimeAxis(boolean isTimeAxis) {
		this.isTimeAxis = isTimeAxis;
	}

	public double getMinValue() {
		return minValue;
	}

	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	public double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}
}
