package com.symantec.gwt.flot.client.pie;

import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.symantec.gwt.flot.client.SeriesOptions;

public class PieSeriesOptions extends SeriesOptions<Slice> {

	private boolean isShowLabel;
	
	public PieSeriesOptions()
	{
		isShowLabel = false;
	}
	
	@Override
	public JSONValue asJson() {
		JSONObject obj = new JSONObject();
		obj.put("pie", getPieConfig());
		
		return obj;
	}

	private JSONValue getPieConfig() {
		
		JSONObject pieConfig = new JSONObject();
		pieConfig.put("show", JSONBoolean.getInstance(true));
		if(isShowLabel)
		{
			JSONObject labelOpts = new JSONObject();
			labelOpts.put("show", JSONBoolean.getInstance(true));
			pieConfig.put("label", labelOpts);
		}
		return pieConfig;
	}

	public boolean isShowLabel() {
		return isShowLabel;
	}

	public void setShowLabel(boolean isShowLabel) {
		this.isShowLabel = isShowLabel;
	}

	
}
