package com.example.urvish.modelClasses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountryResponse{

	@SerializedName("Countries")
	private List<CountriesItem> countries;

	public List<CountriesItem> getCountries(){
		return countries;
	}
}