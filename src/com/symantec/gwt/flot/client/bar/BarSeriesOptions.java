package com.symantec.gwt.flot.client.bar;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.symantec.gwt.flot.client.SeriesOptions;
import com.symantec.gwt.flot.client.axes.FlotAxis.Scale;
import com.symantec.gwt.flot.client.axes.FlotXAxis;
import com.symantec.gwt.flot.client.axes.FlotYAxis;

public class BarSeriesOptions extends SeriesOptions<Column>
{

	public static enum Alignment
	{
		LEFT("left"), CENTER("center");
		
		private String val;
		
		private Alignment(String val)
		{
			this.val = val;
		}

		public String stringValue() {
			return val;
		}
	}
	private boolean isStacked;
	private double barWidth;
	private Alignment barAlignment;
	private boolean isHorizontal;
	private int lineWidth;

	private FlotXAxis xaxis;
	private FlotYAxis yaxis;

	public BarSeriesOptions()
	{
		super();
		isStacked = false;
		barWidth = 0.4f;
		barAlignment = Alignment.CENTER;
		isHorizontal = false;
		lineWidth = 1;
	}
	
	public BarSeriesOptions(boolean isStacked) {
		this();
		this.isStacked = isStacked;
	}
	
	@Override
	public JSONObject getGridOptions() {
		
		JSONObject gridOpts = new JSONObject();
		gridOpts.put("show", JSONBoolean.getInstance(true));
		gridOpts.put("color",new JSONString("#E0E0E0"));
		gridOpts.put("borderWidth", new JSONNumber(1));
		gridOpts.put("borderColor", new JSONString("#DDDDDD"));
		return gridOpts;
	}

	@Override
	public JSONValue asJson() {
		JSONObject obj = new JSONObject();
		obj.put("bars", getBarConfig());
		if(isStacked)
		{
			obj.put("stack", JSONBoolean.getInstance(isStacked));
		}
		return obj;
	}

	private JSONValue getBarConfig() {
		
		JSONObject barConfig = new JSONObject();
		barConfig.put("show", JSONBoolean.getInstance(true));
		barConfig.put("fill", JSONBoolean.getInstance(true));
		//color
	    JSONObject fillColor = new JSONObject(); // fillColor: { colors: [ { opacity: 0.8 }, { opacity: 0.1 } ] }
	    JSONArray color = new JSONArray();
	    JSONObject opacity1 = new JSONObject();
	    JSONObject opacity2 = new JSONObject();
	    opacity1.put("opacity", new JSONNumber(1));
	    opacity2.put("opacity", new JSONNumber(1));
	    color.set(0, opacity1);
	    color.set(1, opacity2);
	    fillColor.put("colors", color);
	    barConfig.put("fillColor", fillColor);
	    
		if(barWidth > 0)
		{
			if(xaxis.isTimeAxis())
			{
				barWidth*= xaxis.getMinTickUnit().getMilliseconds();
			}
			if(xaxis.getScale() == Scale.LOGARITHMIC)
			{
				barWidth = Math.log(barWidth);
			}
			barConfig.put("barWidth", new JSONNumber(barWidth));
		}
		if(barAlignment != null)
		{
			barConfig.put("align", new JSONString(barAlignment.stringValue()));
		}
		barConfig.put("horizontal", JSONBoolean.getInstance(isHorizontal));
		barConfig.put("lineWidth", new JSONNumber(lineWidth));
		return barConfig;
	}

	public boolean isStacked() {
		return isStacked;
	}

	public void setStacked(boolean isStacked) {
		this.isStacked = isStacked;
	}

	public double getBarWidth() {
		return barWidth;
	}

	public void setBarWidth(double barWidth) {
		this.barWidth = barWidth;
	}

	public Alignment getBarAlignment() {
		return barAlignment;
	}

	public void setBarAlignment(Alignment barAlignment) {
		this.barAlignment = barAlignment;
	}

	public boolean isHorizontal() {
		return isHorizontal;
	}

	public void setHorizontal(boolean isHorizontal) {
		this.isHorizontal = isHorizontal;
	}

	void setXaxis(FlotXAxis xaxis)
	{
		this.xaxis = xaxis;
	}

	void setYaxis(FlotYAxis yaxis)
	{
		this.yaxis = yaxis;
	}

	public int getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}

	public FlotXAxis getXaxis() {
		return xaxis;
	}

	public FlotYAxis getYaxis() {
		return yaxis;
	}

}
