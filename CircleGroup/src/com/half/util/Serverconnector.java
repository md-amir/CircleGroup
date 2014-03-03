package com.half.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Hashtable;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;

/**
 * @author amir
 */
public class Serverconnector implements Runnable
{
//	private int timeout = -999;
	public static final int HTTP_STRING = 0;
	public static final int HTTP_IMAGE = 1;
	public static final int NO_TYPE = 2;
	
	public static final String HTTP_GET_METHOD = "GET";
	public static final String HTTP_POST_METHOD = "POST";
	
	private ServerResponseListener serverResponseListener;
	private URL URLString;
	private String httpMethod = HTTP_GET_METHOD;
	private int requestType = -1;
	private int returnDataType = -1;
	
	DispatchHandler dispatchHandler;
	
	
	double lat=-999999, lon=-999999;
	private double bearingDirection =-9999999;
	
	
	public Serverconnector(ServerResponseListener serverResponseListener, Activity activity, String serverAddress, 
			Hashtable<String, String> params, int requestType, int returnDataType) 
	{
		
		this.serverResponseListener = serverResponseListener;
		
		StringBuffer url = new StringBuffer();
		try 
		{
			url.append(serverAddress);
			
			if (params != null)
			{
				Enumeration <String>elements = params.keys();
				
				int i = 0;
				while (elements.hasMoreElements()) 
				{
					String key = (String) elements.nextElement();
					String value = (String) params.get(key);

					if(key.equalsIgnoreCase("lat"))
						lat = Double.parseDouble(value);
					if(key.equalsIgnoreCase("lng"))
						lon = Double.parseDouble(value);
					if(key.equalsIgnoreCase("bearing"))
						bearingDirection = Double.parseDouble(value);
						
					if (i > 0) 
					{
						url.append("&");
					}
					url.append(key);
					url.append("=");
					String encodedStr = URLEncoder.encode(value, "UTF-8");
					url.append(encodedStr);
					i++;
				}
				
			}
			
			
			System.out.println(url.toString());
			this.URLString = new URL(url.toString());
			AppConstants.addDataCount(url.toString().getBytes().length);
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		this.httpMethod = HTTP_GET_METHOD;
		this.requestType = requestType;
		this.returnDataType = returnDataType;
	}
	
	
	public Serverconnector(ServerResponseListener serverResponseListener, Activity activity, String serverAddress, 
			Hashtable<String, String> params, int requestType, int returnDataType, int timeout) 
	{
		
		this.serverResponseListener = serverResponseListener;
//		this.timeout = timeout;
		
		StringBuffer url = new StringBuffer();
		try 
		{
			url.append(serverAddress);
			
			if (params != null)
			{
				Enumeration <String>elements = params.keys();
				
				int i = 0;
				while (elements.hasMoreElements()) 
				{
					String key = (String) elements.nextElement();
					String value = (String) params.get(key);

					if (i > 0) 
					{
						url.append("&");
					}
					url.append(key);
					url.append("=");
					String encodedStr = URLEncoder.encode(value, "UTF-8");
					url.append(encodedStr);
					i++;
				}
				
			}
			System.out.println(url.toString());
			this.URLString = new URL(url.toString());
		} 
		catch (Exception e) 
		{
			//e.printStackTrace();
		}
		
		this.httpMethod = HTTP_GET_METHOD;
		this.requestType = requestType;
		this.returnDataType = returnDataType;
	}
	
	
	public Serverconnector(ServerResponseListener serverResponseListener, Activity activity, String serverAddress,
			Hashtable<String, String> params, String httpMethod, int requestType, int returnDataType)
	{
		this(serverResponseListener, activity, serverAddress, params, requestType, returnDataType);
		this.httpMethod = httpMethod;
	}
	
	public void start()
    {
		if(serverResponseListener!=null)
		{
			dispatchHandler = new DispatchHandler(serverResponseListener);
		}
		(new Thread(this)).start();
    }

	

	
	public void run()
	{
		HttpURLConnection connection = null;
		InputStream inputStream = null;
		
		try
		{
//			Logger.getInstance().writeLog("INFO", URLString.toString());
			try
			{
				connection = (HttpURLConnection) URLString.openConnection();
			}
			catch(Exception e)
			{
				throw new Exception(ErrorMessage.SERVER_DOWN);
			}
			
			connection.setRequestMethod((this.httpMethod == null || this.httpMethod.equals(HTTP_POST_METHOD)) ? HTTP_POST_METHOD : HTTP_GET_METHOD);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			if(requestType!=NO_TYPE)
			{
				connection.setRequestProperty("Accept", "application/json");
			}
//            if(timeout>0)
//	        {
//            	connection.setReadTimeout(timeout*1000);
// 	            connection.setConnectTimeout(timeout*1000);
// 	            //setTimeout(-999);
// 	            timeout = -999;
//            }
//            else
//            {
//            	connection.setReadTimeout(10000);
// 	            connection.setConnectTimeout(10000);
//            }
            try
            {
            	inputStream = connection.getInputStream();
            }
            catch(Exception e)
			{
            	e.printStackTrace();
				throw new Exception(ErrorMessage.NO_INTERNET_AVAILABLE);
			}
            
			int resCode = connection.getResponseCode();
			
			if (resCode != HttpURLConnection.HTTP_OK)
			{
				if(resCode == HttpURLConnection.HTTP_MOVED_PERM ||
                        resCode == HttpURLConnection.HTTP_MOVED_TEMP || resCode == HttpURLConnection.HTTP_SEE_OTHER)
                {
                      this.URLString = new URL(connection.getHeaderField("Location")) ;
                      //Logger.consolePrint("Redirected url :" + this.URLString.toString());
                      
                      run();                     
                }
                else
                {
                	throw new Exception(ErrorMessage.SERVER_DOWN);
                }
			}
			else 
			{
				
				if(this.returnDataType == HTTP_STRING)
				{
					byte b[] = new byte[2048];
					StringBuffer stb = new StringBuffer();
					int readed = -1;
					while((readed = inputStream.read(b)) != -1)
					{
						stb.append(new String(b, 0, readed));
					}
					AppConstants.addDataCount(stb.toString().getBytes().length);
					if (this.dispatchHandler != null)
					{
						this.dispatchHandler.setData(new Response(stb.toString(), this.requestType, returnDataType, true));
						this.dispatchHandler.sendMessage(new Message());
					}
					b = null;
					stb =null;
				}
				else if(this.returnDataType == HTTP_IMAGE)
				{
					Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
					AppConstants.addDataCount(bitmap.getByteCount());
					if (this.dispatchHandler != null)
					{
						this.dispatchHandler.setData(new Response(bitmap, this.requestType, returnDataType, true));
						this.dispatchHandler.sendMessage(new Message());
					}
				}
			}
		} 
		catch (Exception e) 
		{
			if (this.dispatchHandler != null)
			{
				this.dispatchHandler.setData(new Response(null, requestType, HTTP_STRING, false, e, e.getMessage()));
				this.dispatchHandler.sendMessage(new Message());
			}
			//Logger.consolePrint("Sever Connector: Exception in Server connetion");
			//e.printStackTrace();
			
		}
		finally
		{
			try
			{
				if (connection != null)
				{
					connection.disconnect();
				}
				if (inputStream != null)
				{
					inputStream.close();
				}
			}
			catch(Exception e)
			{
				//e.printStackTrace();
			}
			
		}
		
	}
	
	
	public void removeListener()
	{
		this.serverResponseListener = null;
		this.dispatchHandler = null;
	}
}
