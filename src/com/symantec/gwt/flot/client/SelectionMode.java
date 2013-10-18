package com.symantec.gwt.flot.client;

public enum SelectionMode {

	X("x"), Y("y");
	
	private String value;
	private SelectionMode(String value)
	{
		this.value = value;
	}
	
	public String stringVal()
	{
		return this.value;
	}
}
