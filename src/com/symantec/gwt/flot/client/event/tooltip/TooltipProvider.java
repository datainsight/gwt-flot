package com.symantec.gwt.flot.client.event.tooltip;

import com.google.gwt.user.client.ui.Widget;
import com.symantec.gwt.flot.client.ChartFragment;

public interface TooltipProvider<D extends ChartFragment>
{
	public Widget getTooltip(D item); 
}
