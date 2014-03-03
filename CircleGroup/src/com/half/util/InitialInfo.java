package com.half.util;

import java.util.ArrayList;

import com.half.domain.User;

public class InitialInfo {
	public static User own;
	public static ArrayList<User> memberList;
	
	
	public static User getOwn() {
		return own;
	}
	public static void setOwn(User own) {
		InitialInfo.own = own;
	}
	public static ArrayList<User> getMemberList() {
		return memberList;
	}
	public static void setMemberList(ArrayList<User> memberList) {
		InitialInfo.memberList = memberList;
	}
	
	 

}
