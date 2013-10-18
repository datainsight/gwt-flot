package com.symantec.gwt.flot.client.line;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONValue;
import com.symantec.gwt.flot.client.Series;

public class LineSeries extends Series<Point>
{
	private List<Point> points;

	public LineSeries(int colorHex, String label)
	{
		super(colorHex, label);
		points = new ArrayList<Point>();
	}

	public LineSeries(int colorHex, String label, List<Point> points)
	{
		this(colorHex, label);
		this.points.addAll(points);
	}

	public List<Point> getPoints()
	{
		return points;
	}

	public void setPoints(List<Point> points)
	{
		this.points = points;
	}

	public void addPoint(Point point)
	{
		if(points == null)
		{
			points = new ArrayList<Point>();
		}

		points.add(point);
	}

	public void addPoint(double xVal, double yVal)
	{
		addPoint(new Point(xVal, yVal));
	}

	@Override
	protected JSONValue getDataObject()
	{
		JSONArray jsonPoints = new JSONArray();
		int i = 0;
		for(Point p : points)
		{
			JSONArray jpoint = new JSONArray();
			jpoint.set(0, new JSONNumber(p.getX()));
			jpoint.set(1, new JSONNumber(p.getY()));

			jsonPoints.set(i++, jpoint);
		}

		return jsonPoints;
	}

}
