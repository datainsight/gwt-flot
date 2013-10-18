package com.symantec.gwt.flot.client;

public enum TickUnit
{
	HOUR("hour", 3600*1000),
	DAY("day", 24*HOUR.getMilliseconds()),
	MONTH("month", 30*DAY.getMilliseconds()),
	YEAR("year", 12*MONTH.getMilliseconds());
	
	private String value;
	private long milliseconds;
	
	private TickUnit(String value, long milliseconds)
	{
		this.value = value;
		this.milliseconds = milliseconds;
	}
	
	public String asString()
	{
		return value;
	}

	public long getMilliseconds()
	{
		return milliseconds;
	}
}
