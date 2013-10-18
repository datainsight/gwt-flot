package com.symantec.gwt.flot.client;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Widget;

public abstract class SelectableFlot<D extends ChartFragment> extends Flot<D> implements AllowsSelections
{

	protected RangeChangeObsverer rangeObserver;
	protected SelectionMode selectionMode;
	protected boolean isSelectable = false;
	
	public <C extends SeriesOptions<D>> SelectableFlot(C options)
	{
		super(options);
	}
	
	public <C extends SeriesOptions<D>> SelectableFlot(Widget element, C options)
	{
		super(element, options);
	}

	@Override
	protected JSONObject getOptions() {
		
		JSONObject obj = new JSONObject();
		if(isSelectable)
		{
			obj.put("selection", getSelectionConfig());
		}
		return obj;
	}
	
	private JSONValue getSelectionConfig() {
		
		JSONObject selectionConfig = new JSONObject();
		if(selectionMode == null)
		{
			selectionConfig.put("mode", new JSONString("x"));
		}
		else
		{
			selectionConfig.put("mode", new JSONString(selectionMode.stringVal()));
		}

		selectionConfig.put("color", new JSONString("#FFCC33"));
		return selectionConfig;
	}
	

	@Override
	public SelectionMode getSelectionMode() {
		return selectionMode;
	}

	@Override
	public void setSelectionMode(SelectionMode mode) {
		this.selectionMode = mode;
	}

	@Override
	public void setRangeChangeObserver(RangeChangeObsverer observer) {
		
		this.rangeObserver = observer;
	}

	@Override
	public RangeChangeObsverer getRangeChangeObserver() {
		
		return rangeObserver;
	}

	@Override
	protected void afterPlot() {
		
		super.afterPlot();
		addSelectionHandlers();
	}
	
	
	private native void addSelectionHandlers() /*-{

		var self = this;
		var divId = self.@com.symantec.gwt.flot.client.SelectableFlot::getDivId()();
		var selfDiv = $wnd.$('#'+divId);
    	if(self.@com.symantec.gwt.flot.client.SelectableFlot::isSelectable === true)
    	{
    		var selectionHandler = function(event, ranges)
    		{
    			if(typeof self.@com.symantec.gwt.flot.client.SelectableFlot::rangeObserver !== 'undefined')
    			{
    				self.@com.symantec.gwt.flot.client.SelectableFlot::rangeObserver.@com.symantec.gwt.flot.client.RangeChangeObsverer::onRangeChange(DD)(ranges.xaxis.from, ranges.xaxis.to);
    			}
    		};
    		
    		var deselectionHandler = function()
    		{
    			if(typeof self.@com.symantec.gwt.flot.client.SelectableFlot::rangeObserver !== 'undefined')
    			{
    				self.@com.symantec.gwt.flot.client.SelectableFlot::rangeObserver.@com.symantec.gwt.flot.client.RangeChangeObsverer::onRangeReset()();
    			}
    		};
    		
    		selfDiv.on("plotunselected", deselectionHandler);
    		selfDiv.on("plotselected", selectionHandler);
    		
    	}	
    		
	}-*/;


	@Override
	protected void onCleanup() {
		super.onCleanup();
		unbindSelectionEvents();
	}
	private native void unbindSelectionEvents() /*-{
		
		var self = this;
		var selfDiv = $wnd.$('#'+self.@com.symantec.gwt.flot.client.SelectableFlot::getDivId()());
		
		selfDiv.off("plotclick");
		if(self.@com.symantec.gwt.flot.client.SelectableFlot::isSelectable === true)
		{
    		selfDiv.off("plotselected");
    		selfDiv.off("plotunselected");
		}
		
	}-*/;

	@Override
	public native void clearSelection(boolean fireEvent) /*-{
		
		var self = this;
		var graph = self.@com.symantec.gwt.flot.client.Flot::graph;
		
		graph.clearSelection(fireEvent);
		
	}-*/;

	@Override
	public native void setSelection(double from, double to, boolean fireEvent) /*-{

		
		var self = this,
			graph = self.@com.symantec.gwt.flot.client.Flot::graph,
			range = {xaxis: {from: from, to:to}};
			
		graph.setSelection(range, fireEvent);
		
	}-*/;
	
	public boolean isSelectable() {
		return isSelectable;
	}

	public void setSelectable(boolean isSelectable) {
		this.isSelectable = isSelectable;
	}
}
