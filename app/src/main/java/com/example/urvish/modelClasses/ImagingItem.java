package com.example.urvish.modelClasses;

import com.google.gson.annotations.SerializedName;

public class ImagingItem{

	@SerializedName("name")
	private String name;

	@SerializedName("location")
	private String location;

	@SerializedName("time")
	private String time;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}

	@Override
 	public String toString(){
		return 
			"ImagingItem{" + 
			"name = '" + name + '\'' + 
			",location = '" + location + '\'' + 
			",time = '" + time + '\'' + 
			"}";
		}
}