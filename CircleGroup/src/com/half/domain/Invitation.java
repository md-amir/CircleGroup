 package com.half.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Invitation implements Parcelable{
	private String invitationId;
	private String invitationFrom;
	private String invitationTo;
	private String invitationMessage;
	private String invitationDateTime;
	
	private Invitation(Parcel in)
	{
		this.invitationId = in.readString();
		this.invitationFrom = in.readString();
		this.invitationTo = in.readString();
		this.invitationMessage = in.readString();
		this.invitationDateTime = in.readString();
		
	}
	
	public static final Parcelable.Creator<Invitation> CREATOR = new Creator<Invitation>() {

		public Invitation createFromParcel(Parcel in) {
			return new Invitation(in);
		}

		@Override
		public Invitation[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Invitation[size];
		}

		
	};
	
	
	public String getInvitationId() {
		return invitationId;
	}
	public void setInvitationId(String invitationId) {
		this.invitationId = invitationId;
	}
	public String getInvitationFrom() {
		return invitationFrom;
	}
	public void setInvitationFrom(String invitationFrom) {
		this.invitationFrom = invitationFrom;
	}
	public String getInvitationTo() {
		return invitationTo;
	}
	public void setInvitationTo(String invitationTo) {
		this.invitationTo = invitationTo;
	}
	public String getInvitationMessage() {
		return invitationMessage;
	}
	public void setInvitationMessage(String invitationMessage) {
		this.invitationMessage = invitationMessage;
	}
	public String getInvitationDateTime() {
		return invitationDateTime;
	}
	public void setInvitationDateTime(String invitationDateTime) {
		this.invitationDateTime = invitationDateTime;
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeString(invitationId);
		out.writeString(invitationFrom);
		out.writeString(invitationTo);
		out.writeString(invitationMessage);
		out.writeString(invitationDateTime);
		
		
	
		
	}
	
	
	
	
	

}
