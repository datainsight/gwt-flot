package com.symantec.gwt.flot.client;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.symantec.gwt.flot.client.event.click.SeriesClickEvent;
import com.symantec.gwt.flot.client.event.click.SeriesClickHandler;
import com.symantec.gwt.flot.client.event.tooltip.HasFlotTooltipProvider;
import com.symantec.gwt.flot.client.event.tooltip.TooltipProvider;

public abstract class Series<D extends ChartFragment> implements HasFlotTooltipProvider<D>
{
	private int color;
	private String label;
	private Object metaData;
	protected SimpleEventBus eventBus;
	private TooltipProvider<D> provider;
	
	protected Series() 
	{
		super();
		eventBus = new SimpleEventBus();
	}
	protected Series(int colorHex, String label)
	{
		this();
		setColor(colorHex);
		this.label = label;
	}
	public int getColor()
	{
		return color;
	}
	public void setColor(int colorHex)
	{
		if(colorHex > 0xFFFFFF || colorHex < 0)
		{
			throw new IllegalArgumentException("Invalid color value");
		}
		else
		{
			this.color = colorHex;
		}
	}
	
	public String getLabel()
	{
		return label;
	}
	public void setLabel(String label)
	{
		this.label = label;
	}
	
	protected JSONObject asJson()
	{
		JSONObject obj = new JSONObject();
		obj.put("label", new JSONString(label==null?"":label));
		
		String colorHex = Integer.toHexString(color).toUpperCase();
		if(colorHex.length() < 6)
		{
			for(int i = colorHex.length(); i < 6; i++)
			{
				colorHex = "0" + colorHex;
			}
		}
		obj.put("color", new JSONString("#"+colorHex));
		obj.put("data", getDataObject());
		return obj;
	}
	
	protected abstract JSONValue getDataObject();
	
	public Object getMetaData() {
		return metaData;
	}
	public void setMetaData(Object metaData) {
		this.metaData = metaData;
	}
	
	public HandlerRegistration addSeriesClickHandler(SeriesClickHandler<D> handler) {
		
		return eventBus.addHandler(SeriesClickEvent.getType(), handler);
	}
	
	public void fireClickEvent(D data)
	{
		eventBus.fireEvent(new SeriesClickEvent<D>(data));
	}
	

	@Override
	public TooltipProvider<D> getTooltipProvider() {
		return provider;
	}

	@Override
	public void setTooltipProvider(TooltipProvider<D> provider) {
		
		this.provider = provider;
	}
}
