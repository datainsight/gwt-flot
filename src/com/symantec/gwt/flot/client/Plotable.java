package com.symantec.gwt.flot.client;

import com.google.gwt.user.client.ui.Widget;

public interface Plotable
{
	void plot(Widget element);
	void cleanup();
}
