package com.symantec.gwt.flot.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

public class FlotLegend
{
	public static enum Position
	{
		TOP_LEFT("nw"),
		TOP_RIGHT("ne"),
		BOTTOM_RIGHT("se"),
		BOTTOM_LEFT("sw");
		
		private String jsonValue;
		private Position(String jsonValue)
		{
			this.jsonValue = jsonValue;
		}
		String asString()
		{
			return jsonValue;
		}
		
	}
	private JavaScriptObject container;
	private boolean isVisible;
	private Position position;
	private int numberOfColumns;
	
	public FlotLegend()
	{
		isVisible = true;
		position = Position.BOTTOM_LEFT;
	}

	JSONValue asJson()
	{
		JSONObject obj = new JSONObject();
		obj.put("show", JSONBoolean.getInstance(isVisible));
		obj.put("position", new JSONString(position.asString()));
		if(numberOfColumns > 0)
		{
			obj.put("noColumns", new JSONNumber(numberOfColumns));
		}
		if(container != null)
		{
			JSONObject containerRef = new JSONObject(container);
			obj.put("container", containerRef);
		}
		
		return obj;
	}

	public void setVisible(boolean visible)
	{
		this.isVisible = visible;
	}
	
	public void setContainer(Widget element)
	{
		if(element.getElement().getId() == null || element.getElement().getId().trim().length() == 0)
		{
			element.getElement().setId(DOM.createUniqueId());
		}
		String divId = element.getElement().getId();
		__initContainer__(divId);
	}

	private native void __initContainer__(String divId)/*-{
		
		var self = this;
		self.@com.symantec.gwt.flot.client.FlotLegend::container = $wnd.$('#'+divId);
		
	}-*/;

	public boolean isVisible()
	{
		return isVisible;
	}

	public int getNumberOfColumns()
	{
		return numberOfColumns;
	}

	public void setNumberOfColumns(int numberOfColumns)
	{
		this.numberOfColumns = numberOfColumns;
	}
	
}
