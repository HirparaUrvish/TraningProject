package com.example.urvish.modelClasses;

import com.google.gson.annotations.SerializedName;

public class MedicationsItem{

	@SerializedName("sig")
	private String sig;

	@SerializedName("dose")
	private String dose;

	@SerializedName("route")
	private String route;

	@SerializedName("refills")
	private String refills;

	@SerializedName("strength")
	private String strength;

	@SerializedName("name")
	private String name;

	@SerializedName("pillCount")
	private String pillCount;

	public void setSig(String sig){
		this.sig = sig;
	}

	public String getSig(){
		return sig;
	}

	public void setDose(String dose){
		this.dose = dose;
	}

	public String getDose(){
		return dose;
	}

	public void setRoute(String route){
		this.route = route;
	}

	public String getRoute(){
		return route;
	}

	public void setRefills(String refills){
		this.refills = refills;
	}

	public String getRefills(){
		return refills;
	}

	public void setStrength(String strength){
		this.strength = strength;
	}

	public String getStrength(){
		return strength;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPillCount(String pillCount){
		this.pillCount = pillCount;
	}

	public String getPillCount(){
		return pillCount;
	}

	@Override
 	public String toString(){
		return 
			"MedicationsItem{" + 
			"sig = '" + sig + '\'' + 
			",dose = '" + dose + '\'' + 
			",route = '" + route + '\'' + 
			",refills = '" + refills + '\'' + 
			",strength = '" + strength + '\'' + 
			",name = '" + name + '\'' + 
			",pillCount = '" + pillCount + '\'' + 
			"}";
		}
}