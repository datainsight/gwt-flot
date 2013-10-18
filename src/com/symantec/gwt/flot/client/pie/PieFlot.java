package com.symantec.gwt.flot.client.pie;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Widget;
import com.symantec.gwt.flot.client.Flot;

public class PieFlot extends Flot<Slice>
{
	public PieFlot(PieSeriesOptions options)
	{
		super(options);
	}

	public PieFlot(Widget element, PieSeriesOptions options)
	{
		super(element, options);
	}

	@Override
	protected JSONObject getOptions()
	{
		return null;
	}

}
