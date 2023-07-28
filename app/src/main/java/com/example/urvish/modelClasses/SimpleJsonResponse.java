package com.example.urvish.modelClasses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SimpleJsonResponse{

	@SerializedName("labs")
	private List<LabsItem> labs;

	@SerializedName("medications")
	private List<MedicationsItem> medications;

	@SerializedName("imaging")
	private List<ImagingItem> imaging;

	public void setLabs(List<LabsItem> labs){
		this.labs = labs;
	}

	public List<LabsItem> getLabs(){
		return labs;
	}

	public void setMedications(List<MedicationsItem> medications){
		this.medications = medications;
	}

	public List<MedicationsItem> getMedications(){
		return medications;
	}

	public void setImaging(List<ImagingItem> imaging){
		this.imaging = imaging;
	}

	public List<ImagingItem> getImaging(){
		return imaging;
	}

	@Override
 	public String toString(){
		return 
			"SimpleJsonResponse{" + 
			"labs = '" + labs + '\'' + 
			",medications = '" + medications + '\'' + 
			",imaging = '" + imaging + '\'' + 
			"}";
		}
}