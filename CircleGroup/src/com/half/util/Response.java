package com.half.util;




/**
 * 
 * @author amir
 *
 */
public class Response 
{
	
	private double bearingDirection;
	private Object data;
	private int requestType;
	private int dataType;
	private boolean status;
	
	private String message;
	private Exception exception;
	
	
	public Response(Object data, int requestType, int dataType, boolean status)
	{
		this.data = data;
		this.requestType = requestType;
		this.dataType = dataType;
		this.status = status;
		
	}
	
	
	public Response(Object data, int requestType, int dataType, boolean status, Exception exception, String message)
	{
		this(data, requestType, dataType, status);
		this.exception = exception;
		this.message = message;
	}
	
	public Object getData() 
	{
		return this.data;
	}
	
	
	
	public boolean getStatus()
	{
		return this.status;
	}
	
	public int getRequetType() 
	{
		return requestType;
	}
	
	public int getDataType() 
	{
		return dataType;
	}


	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message) 
	{
		this.message = message;
	}
	public Exception getException() 
	{
		return exception;
	}
	
	
	public double getBearingDirection()
	{
		return bearingDirection;
	}
	
}
