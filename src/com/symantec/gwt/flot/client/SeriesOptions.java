package com.symantec.gwt.flot.client;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public abstract class SeriesOptions<D extends ChartFragment> {
	
	public abstract JSONValue asJson();

	public  JSONObject getGridOptions() {
		return null;
	}

}
