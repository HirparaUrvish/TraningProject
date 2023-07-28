package com.example.urvish.modelClasses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserListRespon{

	@SerializedName("UserListRespon")
	private ArrayList<UserListResponItem> userListRespon;

	public void setUserListRespon(ArrayList<UserListResponItem> userListRespon){
		this.userListRespon = userListRespon;
	}

	public ArrayList<UserListResponItem> getUserListRespon(){
		return userListRespon;
	}

	@Override
 	public String toString(){
		return 
			"UserListRespon{" + 
			"userListRespon = '" + userListRespon + '\'' + 
			"}";
		}
}