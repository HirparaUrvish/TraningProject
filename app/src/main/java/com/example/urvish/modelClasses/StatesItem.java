package com.example.urvish.modelClasses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StatesItem{

	@SerializedName("StateName")
	private String stateName;

	@SerializedName("Cities")
	private List<String> cities;

	public String getStateName(){
		return stateName;
	}

	public List<String> getCities(){
		return cities;
	}
}