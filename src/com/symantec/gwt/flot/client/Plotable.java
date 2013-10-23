package com.symantec.gwt.flot.client;

import com.google.gwt.user.client.ui.Widget;

/**
 * An interface that is implemented by the {@link Flot} base class
 */
public interface Plotable
{
	/**
	 * Draws the Flot graph inside an element, replacing an existing content.<br/>
	 * Classes implementing this method should ideally call the <code>$.plot()</code> here.
	 * @param element The element inside which the graph needs to be drawn
	 */
	void plot(Widget element);
	
	/**
	 * Destroys event handlers and other references to DOM.
	 */
	void cleanup();
}
