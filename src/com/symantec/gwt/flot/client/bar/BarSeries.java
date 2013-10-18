package com.symantec.gwt.flot.client.bar;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONValue;
import com.symantec.gwt.flot.client.Series;

public class BarSeries extends Series<Column>
{
	private List<Column> values;

	public BarSeries(int colorHex, String label)
	{
		super(colorHex, label);
		values = new ArrayList<Column>();
	}

	public BarSeries(List<Column> values, int colorHex, String label)
	{
		this(colorHex, label);
		this.values = values;
	}

	@Override
	protected JSONValue getDataObject()
	{

		JSONArray data = new JSONArray();
		int i = 0;
		for(Column d : values)
		{
			JSONArray v = new JSONArray();
			v.set(0, new JSONNumber(d.getAbsoluteX()));
			v.set(1, new JSONNumber(d.getHeight()));
			data.set(i++, v);
		}

		return data;
	}

	public List<Column> getValues()
	{
		return values;
	}

	public void setValues(List<Column> values)
	{
		this.values = values;
	}

	public void addValue(double value)
	{

		if(this.values == null)
		{
			values = new ArrayList<Column>();
		}
		int pos = values.size();
		Column c = new Column(value, pos);
		values.add(c);
	}

	public void addColumn(Column value)
	{
		if(this.values == null)
		{
			values = new ArrayList<Column>();
		}
		int pos = values.size();
		value.setPosition(pos);
		values.add(value);
	}

}
