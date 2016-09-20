package com.model;

public class AdvertiserInfo {
	private String name;
	private String advertiserId;
	private String password;
	public AdvertiserInfo(String name, String advertiserId, String password, String address, String phoneNumber,
			String questiom, String answer) {
		super();
		this.name = name;
		this.advertiserId = advertiserId;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.questiom = questiom;
		this.answer = answer;
	}
	private String address;
	private String phoneNumber;
	private String questiom;
	private String answer;
	public AdvertiserInfo()
	{}
	public String getQuestiom() {
		return questiom;
	}
	public void setQuestiom(String questiom) {
		this.questiom = questiom;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdvertiserId() {
		return advertiserId;
	}
	public void setAdvertiserId(String advertiserId) {
		this.advertiserId = advertiserId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


}
