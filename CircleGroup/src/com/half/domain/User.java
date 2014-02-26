package com.half.domain;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

	private String name;
	private String email;
	private String password;
	private String mobileNumber;
	private String profilePic;
	private String url;
	private Department department;
	private Medias media;
	private Team team;

	
	private User(Parcel in)
	{
		 email = in.readString();
		 name  = in.readString();
		 password  = in.readString();
		 url  = in.readString();
		 mobileNumber  = in.readString();
		 //profilePic = (Bitmap)in.readParcelable(getClass().getClassLoader());
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUniqueNumber() {
		return password;
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

	public String getImage() {
		return profilePic;
	}

	public void setImage(String image) {
		this.profilePic = image;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Medias getMedia() {
		return media;
	}

	public void setMedia(Medias media) {
		this.media = media;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		// TODO Auto-generated method stub
		out.writeString( name );
		out.writeString( email );
		out.writeString( password );
		out.writeString( mobileNumber );
		out.writeString( url );
//		out.writeParcelable( profilePic, flags);
//		out.writeString( department );
//		out.writeString( media );
//		out.writeString( team );
//		out.writeString(  );
//		out.writeString(  );
		
	}

}
