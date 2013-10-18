package com.symantec.gwt.flot.client.event.tooltip;

import com.symantec.gwt.flot.client.ChartFragment;

public interface HasFlotTooltipProvider<D extends ChartFragment> {

	public TooltipProvider<D> getTooltipProvider();
	public void setTooltipProvider(TooltipProvider<D> provider);
	
}
