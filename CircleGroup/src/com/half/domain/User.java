package com.half.domain;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

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
	
	private static JSONArray jObjarray;
	private static ArrayList<User> allUserList;
	
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


	}
	
	public static ArrayList<User> parse(String data)
	{
		allUserList = new ArrayList<User>();
	
		
		try 
		{
			jObjarray = new JSONArray(data);
			Log.v("size","length"+jObjarray.length());
			
			
			for(int i=0; i<jObjarray.length();i++){
				
			JSONObject jObj = jObjarray.getJSONObject(i);
			
			User temp = new User();
			temp.setName(jObj.getString("emp_name"));
			temp.setAdmin(Integer.parseInt(jObj.getString("emp_admin"))==1);
			temp.setBusNumber(jObj.getString("emp_bus"));
			temp.setDegignation(jObj.getString("emp_designation"));
			temp.setMobileNumber(jObj.getString("emp_mobile"));
//			temp.setEmail(jObj.getString("emp_name"));
			temp.setLosTeamName(jObj.getString("emp_team"));
			temp.setOrganization(jObj.getString("emp_department"));
			temp.setRoomNumber(jObj.getString("emp_room"));
			temp.setTeamName(jObj.getString("emp_team"));
			temp.setUniqueNumber(jObj.getString("emp_code"));
			temp.setUrl(jObj.getString("emp_picture"));
			//emp_id
			allUserList.add(temp);
			
			}
			
//			JSONObject result = new JSONObject(data).getJSONObject("result");
//			
//		    allUserList = new ArrayList<User>();
//			user.setEmail(result.getJSONObject("signInUser").getString("uuid"));
//			user.setName(result.getJSONObject("signInUser").getString("name"));
//			user.setPassword(result.getJSONObject("signInUser").getString("password"));
//			user.setMiddleName(result.getJSONObject("signInUser").getString("middle_name") == null ? "" : result.getJSONObject("signInUser").getString("middle_name"));
//			
			return  allUserList;
			// Parse rest of them
		}
		catch (Exception e){
			
		}
		return null;
	}
	
	

}
