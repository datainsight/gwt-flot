package com.symantec.gwt.flot.client;

public interface RangeChangeObsverer {

	void onRangeChange(double lowerBound, double upperBound);
	void onRangeReset();
}
