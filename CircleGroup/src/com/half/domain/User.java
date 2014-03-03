package com.half.domain;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

	

	private String name;
	private String degignation;
	private String email;
	private String password;
	private String mobileNumber;
	private String roomNumber;
	private String busNumber;
	private String teamName;
	private Bitmap profilePic;
	private String losTeamName;
	private String organization;
	private boolean isAdmin;

	private String url;

	private User(Parcel in) {
		this.name = in.readString();
		this.degignation = in.readString();
		this.email = in.readString();
		this.password = in.readString();
		this.mobileNumber = in.readString();
		this.roomNumber = in.readString();
		this.teamName = in.readString();
		this.busNumber = in.readString();
		this.organization = in.readString();
		this.losTeamName = in.readString();
		this.url = in.readString();
		this.isAdmin = in.readByte() != 0;

		// profilePic = (Bitmap) in.readParcelable(getClass().getClassLoader());

	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public static final Parcelable.Creator<User> CREATOR = new Creator<User>() {

		public User createFromParcel(Parcel in) {
			return new User(in);
		}

		@Override
		public User[] newArray(int size) {
			// TODO Auto-generated method stub
			return new User[size];
		}

		/*
		 * public Student[] newArray(int size) { return new Student[size]; }
		 */
	};

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDegignation() {
		return degignation;
	}

	public void setDegignation(String degignation) {
		this.degignation = degignation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLosTeamName() {
		return losTeamName;
	}

	public void setLosTeamName(String losTeamName) {
		this.losTeamName = losTeamName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getUniqueNumber() {
		return password;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setUniqueNumber(String uniqueNumber) {
		this.password = uniqueNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Bitmap getImage() {
		return profilePic;
	}

	public void setImage(Bitmap image) {
		this.profilePic = image;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		// TODO Auto-generated method stub
		out.writeString(name);
		out.writeString(degignation);
		out.writeString(email);
		out.writeString(password);
		out.writeString(mobileNumber);
		out.writeString(roomNumber);
		out.writeString(teamName);
		out.writeString(busNumber);
		out.writeString(organization);
		out.writeString(losTeamName);
		out.writeString(url);
		out.writeByte((byte)(isAdmin ? 1 : 0 ) );
		// out.writeParcelable(profilePic, flags);
		
		
//		this.name = in.readString();
//		this.degignation = in.readString();
//		this.email = in.readString();
//		this.password = in.readString();
//		this.mobileNumber = in.readString();
//		this.roomNumber = in.readString();
//		this.teamName = in.readString();
//		this.busNumber = in.readString();
//		this.organization = in.readString();
//		this.losTeamName = in.readString();
//		this.url = in.readString();

	}

}
