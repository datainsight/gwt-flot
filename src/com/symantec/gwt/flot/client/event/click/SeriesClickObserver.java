package com.symantec.gwt.flot.client.event.click;

import com.symantec.gwt.flot.client.ChartFragment;

public interface SeriesClickObserver<D extends ChartFragment> {

	void onSeriesClicked(D data);
}
