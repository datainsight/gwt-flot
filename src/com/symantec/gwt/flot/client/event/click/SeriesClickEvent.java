package com.symantec.gwt.flot.client.event.click;

import com.google.gwt.event.shared.GwtEvent;
import com.symantec.gwt.flot.client.ChartFragment;

public class SeriesClickEvent<D extends ChartFragment> extends GwtEvent<SeriesClickHandler<D>> {

	private static Type<SeriesClickHandler<?>> TYPE;
	
	private D data;
	
	public SeriesClickEvent(D data) {
		super();
		this.data = data;
	}

	@Override
	protected void dispatch(SeriesClickHandler<D> handler) {

		handler.onSeriesClicked(this);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Type<SeriesClickHandler<D>> getAssociatedType() {
		return (Type)TYPE;
	}
	
	public static Type<SeriesClickHandler<?>> getType()
	{
		if(TYPE == null)
		{
			TYPE = new Type<SeriesClickHandler<?>>();
		}
		return TYPE;
	}

	public D getData() {
		return data;
	}

	public void setData(D data) {
		this.data = data;
	}
	

}
