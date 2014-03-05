package com.half.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Schedule implements Parcelable {
	
	private String scheduleId;
	private String scheduleTitle;
	private String scheduleDescription;
	private String scheduleStartTime;
	private String scheduleEndTime;
	private String scheduleVenue;
	private String scheduleDateTime;
	
	
	
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
	
	
	

}
