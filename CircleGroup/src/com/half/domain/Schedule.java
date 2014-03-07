package com.half.domain;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

public class Schedule implements Parcelable {
	
	private String scheduleId;
	private String scheduleTitle;
	private String scheduleDescription;
	private String scheduleStartTime;
	private String scheduleEndTime;
	private String scheduleVenue;
	private String scheduleDateTime;
	
	private static ArrayList<Schedule> scheduleList;
	
	
	
	public String getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getScheduleTitle() {
		return scheduleTitle;
	}
	public void setScheduleTitle(String scheduleTitle) {
		this.scheduleTitle = scheduleTitle;
	}
	public String getScheduleDescription() {
		return scheduleDescription;
	}
	public void setScheduleDescription(String scheduleDescription) {
		this.scheduleDescription = scheduleDescription;
	}
	public String getScheduleStartTime() {
		return scheduleStartTime;
	}
	public void setScheduleStartTime(String scheduleStartTime) {
		this.scheduleStartTime = scheduleStartTime;
	}
	public String getScheduleEndTime() {
		return scheduleEndTime;
	}
	public void setScheduleEndTime(String scheduleEndTime) {
		this.scheduleEndTime = scheduleEndTime;
	}
	public String getScheduleVenue() {
		return scheduleVenue;
	}
	public void setScheduleVenue(String scheduleVenue) {
		this.scheduleVenue = scheduleVenue;
	}
	public String getScheduleDateTime() {
		return scheduleDateTime;
	}
	public void setScheduleDateTime(String scheduleDateTime) {
		this.scheduleDateTime = scheduleDateTime;
	}
	
	private Schedule(Parcel in)
	{
		this.scheduleId = in.readString();
		this.scheduleTitle = in.readString();
		this.scheduleDescription = in.readString();
		this.scheduleStartTime = in.readString();
		this.scheduleEndTime = in.readString();
		this.scheduleVenue = in.readString();
		this.scheduleDateTime = in.readString();
	
		
	}
	
	public Schedule() {
		// TODO Auto-generated constructor stub
	}

	public static final Parcelable.Creator<Schedule> CREATOR = new Creator<Schedule>() {

		public Schedule createFromParcel(Parcel in) {
			return new Schedule(in);
		}

		@Override
		public Schedule[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Schedule[size];
		}

		
	};
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeString(scheduleId);
		out.writeString(scheduleTitle);
		out.writeString(scheduleDescription);
		out.writeString(scheduleStartTime);
		out.writeString(scheduleEndTime);
		out.writeString(scheduleVenue);
		out.writeString(scheduleDateTime);
		
	}
	
	public static ArrayList<Schedule> parse(String data) {

		scheduleList = new ArrayList<Schedule>();
	
		
		try 
		{
		    JSONArray jObjarray = new JSONArray(data);
			Log.v("size","length"+jObjarray.length());
			
			
			for(int i=0; i<jObjarray.length();i++){
				
			JSONObject jObj = jObjarray.getJSONObject(i);
			
			Schedule temp = new Schedule();
			temp.setScheduleId(jObj.getString("schedule_id"));
			temp.setScheduleTitle(jObj.getString("schedule_title"));
			temp.setScheduleVenue(jObj.getString("schedule_venue"));
			temp.setScheduleStartTime(jObj.getString("schedule_starttime"));
			temp.setScheduleEndTime(jObj.getString("schedule_endtime"));
			temp.setScheduleDateTime(jObj.getString("schedule_datetime"));
			temp.setScheduleDescription(jObj.getString("schedule_description"));
			scheduleList.add(temp);
			}	
			
			return  scheduleList;
			
		}
		catch (Exception e){
			
		}
		return null;
	}
	
	
	

}
