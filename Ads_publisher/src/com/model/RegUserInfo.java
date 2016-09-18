package com.model;

public class RegUserInfo {
	private String advName;
	private String advId;
	private String advPassword;
	private String advAddress;
	private String advContact;
	private String advQuestion;
	private String advAns;
	/**
	 * @return the advName
	 */
	
	public RegUserInfo(String advName, String advId, String advPassword,
			String advAddress, String advContact, String advQuestion,
			String advAns) {
		super();
		this.advName = advName;
		this.advId = advId;
		this.advPassword = advPassword;
		this.advAddress = advAddress;
		this.advContact = advContact;
		this.advQuestion = advQuestion;
		this.advAns = advAns;
	}
	public RegUserInfo() {
		// TODO Auto-generated constructor stub
	}
	public String getAdvName() {
		return advName;
	}
	/**
	 * @param advName the advName to set
	 */
	public void setAdvName(String advName) {
		this.advName = advName;
	}
	/**
	 * @return the advId
	 */
	public String getAdvId() {
		return advId;
	}
	/**
	 * @param advId the advId to set
	 */
	public void setAdvId(String advId) {
		this.advId = advId;
	}
	/**
	 * @return the advPassword
	 */
	public String getAdvPassword() {
		return advPassword;
	}
	/**
	 * @param advPassword the advPassword to set
	 */
	public void setAdvPassword(String advPassword) {
		this.advPassword = advPassword;
	}
	/**
	 * @return the advAddress
	 */
	public String getAdvAddress() {
		return advAddress;
	}
	/**
	 * @param advAddress the advAddress to set
	 */
	public void setAdvAddress(String advAddress) {
		this.advAddress = advAddress;
	}
	/**
	 * @return the advContact
	 */
	public String getAdvContact() {
		return advContact;
	}
	/**
	 * @param advContact the advContact to set
	 */
	public void setAdvContact(String advContact) {
		this.advContact = advContact;
	}
	/**
	 * @return the advQuestion
	 */
	public String getAdvQuestion() {
		return advQuestion;
	}
	/**
	 * @param advQuestion the advQuestion to set
	 */
	public void setAdvQuestion(String advQuestion) {
		this.advQuestion = advQuestion;
	}
	/**
	 * @return the advAns
	 */
	public String getAdvAns() {
		return advAns;
	}
	/**
	 * @param advAns the advAns to set
	 */
	public void setAdvAns(String advAns) {
		this.advAns = advAns;
	}

}
