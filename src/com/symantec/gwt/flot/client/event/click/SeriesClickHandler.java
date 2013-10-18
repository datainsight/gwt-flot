package com.symantec.gwt.flot.client.event.click;

import com.google.gwt.event.shared.EventHandler;
import com.symantec.gwt.flot.client.ChartFragment;

public interface SeriesClickHandler<D extends ChartFragment> extends EventHandler {
	
	void onSeriesClicked(SeriesClickEvent<D> event);

}
