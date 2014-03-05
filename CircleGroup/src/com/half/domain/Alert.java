package com.half.domain;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

public class Alert implements Parcelable{
	private static ArrayList<Alert> alertList;
	private static JSONArray jObjarray ;
	
	
	private String alertId;
	private String alertSubject;
	private String alertMessage;
	private String alertDateTime;
	
	private Alert(Parcel in)
	{
		this.alertId = in.readString();
		this.alertSubject = in.readString();
		this.alertMessage = in.readString();
		this.alertDateTime = in.readString();
		
	}
	
	public Alert() {
		// TODO Auto-generated constructor stub
	}

	public static final Parcelable.Creator<Alert> CREATOR = new Creator<Alert>() {

		public Alert createFromParcel(Parcel in) {
			return new Alert(in);
		}

		@Override
		public Alert[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Alert[size];
		}

		
	};
	
	
	public String getAlertId() {
		return alertId;
	}
	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}
	public String getAlertSubject() {
		return alertSubject;
	}
	public void setAlertSubject(String alertSubject) {
		this.alertSubject = alertSubject;
	}
	public String getAlertMessage() {
		return alertMessage;
	}
	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}
	public String getAlertDateTime() {
		return alertDateTime;
	}
	public void setAlertDateTime(String alertDateTime) {
		this.alertDateTime = alertDateTime;
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel out, int flag) {
		out.writeString(alertId);
		out.writeString(alertSubject);
		out.writeString(alertMessage);
		out.writeString(alertDateTime);
		
		
	}
	public static ArrayList<Alert> parse(String data) {

		alertList = new ArrayList<Alert>();
	
		
		try 
		{
		    jObjarray = new JSONArray(data);
			Log.v("size","length"+jObjarray.length());
			
			
			for(int i=0; i<jObjarray.length();i++){
				
			JSONObject jObj = jObjarray.getJSONObject(i);
			
			Alert temp = new Alert();
			temp.setAlertId(jObj.getString("alert_id"));
			temp.setAlertSubject(jObj.getString("alert_subject"));
			temp.setAlertMessage(jObj.getString("alert_message"));
			temp.setAlertDateTime(jObj.getString("alert_datetime"));
			alertList.add(temp);
			}	
			
			return  alertList;
			
		}
		catch (Exception e){
			
		}
		return null;
	}
	

}
