package com.symantec.gwt.flot.client.line;

import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.symantec.gwt.flot.client.SeriesOptions;

public class LineSeriesOptions extends SeriesOptions<Point> {

	private boolean isStepped;
	private boolean isStacked;
	private boolean isFillArea;
	private boolean isShowPoints;
	
	public LineSeriesOptions() 
	{
		super();
		isStepped = false;
		isFillArea = false;
		isStacked = false;
	}
	
	private JSONValue getPointConfig()
	{
		JSONObject pointsConfig = new JSONObject();
		pointsConfig.put("show", JSONBoolean.getInstance(true));
		return pointsConfig;
	}
	private JSONValue getLineConfig()
	{
		JSONObject lineConfig = new JSONObject();
		lineConfig.put("show", JSONBoolean.getInstance(true));
		lineConfig.put("steps", JSONBoolean.getInstance(isStepped));
		lineConfig.put("fill", JSONBoolean.getInstance(isFillArea));
		return lineConfig;
	}
	
	@Override
	public JSONValue asJson() 
	{
		JSONObject obj = new JSONObject();
		if(isStacked)
		{
			obj.put("stack", JSONBoolean.getInstance(true));
		}
		obj.put("lines", getLineConfig());
		
		if(isShowPoints)
		{
			obj.put("points", getPointConfig());
		}
		
		return obj;
	}
	
	public JSONValue getMarkingsConfig()
	{
		JSONObject pointsConfig = new JSONObject();
		pointsConfig.put("color", new JSONString("#999999"));
		return pointsConfig;
	}
	public boolean isStepped() {
		return isStepped;
	}
	
	public void setStepped(boolean isStepped) {
		this.isStepped = isStepped;
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
	
	public boolean isStacked() 
	{
		return isStacked;
	}
	
	public void setStacked(boolean isStacked) 
	{
		this.isStacked = isStacked;
	}
	
	public boolean isFillArea() 
	{
		return isFillArea;
	}
	public void setFillArea(boolean isFillArea) {
		this.isFillArea = isFillArea;
	}

	public boolean isShowPoints() {
		return isShowPoints;
	}

	public void setShowPoints(boolean isShowPoints) {
		this.isShowPoints = isShowPoints;
	}

}
