package com.symantec.gwt.flot.client.bar;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Widget;
import com.symantec.gwt.flot.client.SelectableFlot;
import com.symantec.gwt.flot.client.axes.FlotXAxis;
import com.symantec.gwt.flot.client.axes.FlotYAxis;
import com.symantec.gwt.flot.client.axes.HasAxes;

public class BarFlot extends SelectableFlot<Column> implements HasAxes {

	private FlotXAxis xaxis = new FlotXAxis();
	private FlotYAxis yaxis = new FlotYAxis();
	
	public BarFlot(BarSeriesOptions options)
	{
		super(options);
	}

	public BarFlot(Widget element, BarSeriesOptions options)
	{
		super(element, options);
	}

	@Override
	protected JSONObject getOptions() {
		
		JSONObject obj = super.getOptions();
		obj.put("xaxis", xaxis.asJson());
		obj.put("yaxis", yaxis.asJson());
		return obj;
	}
	
	
	public FlotXAxis getXaxis()
	{
		return xaxis;
	}
	public void setXaxis(FlotXAxis xaxis)
	{
		this.xaxis = xaxis;
		if(seriesOptions instanceof BarSeriesOptions)
		{
			BarSeriesOptions options = (BarSeriesOptions) seriesOptions;
			options.setXaxis(xaxis);
		}
	}
	public FlotYAxis getYaxis()
	{
		return yaxis;
	}
	public void setYaxis(FlotYAxis yaxis)
	{
		if(seriesOptions instanceof BarSeriesOptions)
		{
			BarSeriesOptions options = (BarSeriesOptions) seriesOptions;
			options.setYaxis(yaxis);
		}
		this.yaxis = yaxis;
	}


}
