package com.half.util;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.AndroidHttpClient;
import android.util.Log;

import com.half.domain.User;

public class AppHandler {
	
	
	public static String callForward;
	public static String scheduleOperation;
	
	public static String getScheduleOperation() {
		return scheduleOperation;
	}

	public static void setScheduleOperation(String scheduleOperation) {
		AppHandler.scheduleOperation = scheduleOperation;
	}

	public static String getCallForward() {
		return callForward;
	}

	public static void setCallForward(String callForward) {
		AppHandler.callForward = callForward;
	}

	public static ArrayList<User> list;
	
	public static ArrayList<User> getEmployeeCatagoriList(String organizationName)
	{
		list = new ArrayList<User>();
		ArrayList<User> allMemberList = InitialInfo.getMemberList();
				
		for(User user: allMemberList)
		{
			if(user.getOrganization().contains(organizationName))
			{
				list.add(user);
			}
		}
		
		return list;
		
	}
	
	public static ArrayList<User> getEmployeeLosList(String losTeamName)
	{
		list = new ArrayList<User>();
		ArrayList<User> allMemberList = InitialInfo.getMemberList();
				
		for(User user: allMemberList)
		{
			if(user.getLosTeamName().contains(losTeamName))
			{
				list.add(user);
			}
		}
		
		return list;
		
	}
	


}
