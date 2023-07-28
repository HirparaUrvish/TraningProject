package com.example.urvish.modelClasses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountriesItem{

	/*Woc_Activity woc_activity=new Woc_Activity();
	int c=woc_activity.oo;*/

	@SerializedName("States")
	private List<StatesItem> states;

	@SerializedName("CountryName")
	private String countryName;

	public List<StatesItem> getStates(){
		return states;
	}

	public String getCountryName(){
		return countryName;
	}
}