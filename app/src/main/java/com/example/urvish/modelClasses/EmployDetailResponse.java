package com.example.urvish.modelClasses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployDetailResponse{

	@SerializedName("EmployeeDetails")
	private List<EmployeeDetailsItem> employeeDetails;

	public void setEmployeeDetails(List<EmployeeDetailsItem> employeeDetails){
		this.employeeDetails = employeeDetails;
	}

	public List<EmployeeDetailsItem> getEmployeeDetails(){
		return employeeDetails;
	}

	@Override
 	public String toString(){
		return 
			"EmployDetailResponse{" + 
			"employeeDetails = '" + employeeDetails + '\'' + 
			"}";
		}
}