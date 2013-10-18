package com.symantec.gwt.flot.client;

public interface AllowsSelections {

	boolean isSelectable();
	void setSelectable(boolean isSelectable);
	SelectionMode getSelectionMode();
	void setSelectionMode(SelectionMode mode);
	void setRangeChangeObserver(RangeChangeObsverer observer);
	RangeChangeObsverer getRangeChangeObserver();
	void clearSelection(boolean fireEvent);
	void setSelection(double from, double to, boolean fireEvent);
}
