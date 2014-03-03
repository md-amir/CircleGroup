package com.half.util;

import android.os.Message;

/**
 * 
 * @author amir
 *
 */
public class DispatchHandler extends android.os.Handler
{
	private ServerResponseListener di;
	private Response response;
	
	public DispatchHandler(ServerResponseListener di)
	{
		this.di = di;
	}
	
	@Override
	public void handleMessage(Message msg)
	{
		di.serverResponse(response);
		
	}
	
	public void setData(Response response)
	{
		this.response = response;
	}
}
