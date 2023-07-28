package com.example.urvish.modelClasses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeDetailsItem{

	@SerializedName("address")
	private String address;

	@SerializedName("gender")
	private String gender;

	@SerializedName("latitude")
	private Object latitude;

	@SerializedName("greeting")
	private String greeting;

	@SerializedName("about")
	private String about;

	@SerializedName("index")
	private int index;

	@SerializedName("registered")
	private String registered;

	@SerializedName("isActive")
	private boolean isActive;

	@SerializedName("url")
	private String url;

	@SerializedName("picture")
	private String picture;

	@SerializedName("friends")
	private List<FriendsItem> friends;

	@SerializedName("tags")
	private List<String> tags;

	@SerializedName("favoriteFruit")
	private String favoriteFruit;

	@SerializedName("balance")
	private String balance;

	@SerializedName("eyeColor")
	private String eyeColor;

	@SerializedName("phone")
	private String phone;

	@SerializedName("name")
	private String name;

	@SerializedName("guid")
	private String guid;

	@SerializedName("company")
	private String company;

	@SerializedName("_id")
	private String id;

	@SerializedName("age")
	private int age;

	@SerializedName("email")
	private String email;

	@SerializedName("longitude")
	private Object longitude;

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setLatitude(Object latitude){
		this.latitude = latitude;
	}

	public Object getLatitude(){
		return latitude;
	}

	public void setGreeting(String greeting){
		this.greeting = greeting;
	}

	public String getGreeting(){
		return greeting;
	}

	public void setAbout(String about){
		this.about = about;
	}

	public String getAbout(){
		return about;
	}

	public void setIndex(int index){
		this.index = index;
	}

	public int getIndex(){
		return index;
	}

	public void setRegistered(String registered){
		this.registered = registered;
	}

	public String getRegistered(){
		return registered;
	}

	public void setIsActive(boolean isActive){
		this.isActive = isActive;
	}

	public boolean isIsActive(){
		return isActive;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setPicture(String picture){
		this.picture = picture;
	}

	public String getPicture(){
		return picture;
	}

	public void setFriends(List<FriendsItem> friends){
		this.friends = friends;
	}

	public List<FriendsItem> getFriends(){
		return friends;
	}

	public void setTags(List<String> tags){
		this.tags = tags;
	}

	public List<String> getTags(){
		return tags;
	}

	public void setFavoriteFruit(String favoriteFruit){
		this.favoriteFruit = favoriteFruit;
	}

	public String getFavoriteFruit(){
		return favoriteFruit;
	}

	public void setBalance(String balance){
		this.balance = balance;
	}

	public String getBalance(){
		return balance;
	}

	public void setEyeColor(String eyeColor){
		this.eyeColor = eyeColor;
	}

	public String getEyeColor(){
		return eyeColor;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setGuid(String guid){
		this.guid = guid;
	}

	public String getGuid(){
		return guid;
	}

	public void setCompany(String company){
		this.company = company;
	}

	public String getCompany(){
		return company;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return age;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setLongitude(Object longitude){
		this.longitude = longitude;
	}

	public Object getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"EmployeeDetailsItem{" + 
			"address = '" + address + '\'' + 
			",gender = '" + gender + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",greeting = '" + greeting + '\'' + 
			",about = '" + about + '\'' + 
			",index = '" + index + '\'' + 
			",registered = '" + registered + '\'' + 
			",isActive = '" + isActive + '\'' + 
			",url = '" + url + '\'' + 
			",picture = '" + picture + '\'' + 
			",friends = '" + friends + '\'' + 
			",tags = '" + tags + '\'' + 
			",favoriteFruit = '" + favoriteFruit + '\'' + 
			",balance = '" + balance + '\'' + 
			",eyeColor = '" + eyeColor + '\'' + 
			",phone = '" + phone + '\'' + 
			",name = '" + name + '\'' + 
			",guid = '" + guid + '\'' + 
			",company = '" + company + '\'' + 
			",_id = '" + id + '\'' + 
			",age = '" + age + '\'' + 
			",email = '" + email + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}