package com.half.util;

import java.util.ArrayList;

import com.half.domain.User;

public class AppHandler {
	
	
	public static String callForward;
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
