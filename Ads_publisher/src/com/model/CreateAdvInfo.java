package com.model;

public class CreateAdvInfo {
	
	private String advUser;
	//private String advId;
	private String advTitle;
	private String advTheme;
	private String advDescription;
	private String advImage1;
	private String advImage2;
	private String advImage3;
	private String advVideo;
	private String advCategory;
	private String advSubCategory;
	private String advPriority;
	//private String advApprove;
	
	/**
	 * @return the advUser
	 */
	public String getAdvUser() {
		return advUser;
	}
	public CreateAdvInfo(String advUser, String advTitle, String advTheme,
			String advDescription, String advImage1, String advImage2,
			String advImage3, String advVideo, String advCategory,
			String advSubCategory, String advPriority) {
		super();
		this.advUser = advUser;
		this.advTitle = advTitle;
		this.advTheme = advTheme;
		this.advDescription = advDescription;
		this.advImage1 = advImage1;
		this.advImage2 = advImage2;
		this.advImage3 = advImage3;
		this.advVideo = advVideo;
		this.advCategory = advCategory;
		this.advSubCategory = advSubCategory;
		this.advPriority = advPriority;
	}
	/**
	 * @param advUser the advUser to set
	 */
	public void setAdvUser(String advUser) {
		this.advUser = advUser;
	}
	/**
	 * @return the advTitle
	 */
	public String getAdvTitle() {
		return advTitle;
	}
	/**
	 * @param advTitle the advTitle to set
	 */
	public void setAdvTitle(String advTitle) {
		this.advTitle = advTitle;
	}
	/**
	 * @return the advTheme
	 */
	public String getAdvTheme() {
		return advTheme;
	}
	/**
	 * @param advTheme the advTheme to set
	 */
	public void setAdvTheme(String advTheme) {
		this.advTheme = advTheme;
	}
	/**
	 * @return the advDescription
	 */
	public String getAdvDescription() {
		return advDescription;
	}
	/**
	 * @param advDescription the advDescription to set
	 */
	public void setAdvDescription(String advDescription) {
		this.advDescription = advDescription;
	}
	/**
	 * @return the advImage1
	 */
	public String getAdvImage1() {
		return advImage1;
	}
	/**
	 * @param advImage1 the advImage1 to set
	 */
	public void setAdvImage1(String advImage1) {
		this.advImage1 = advImage1;
	}
	/**
	 * @return the advImage2
	 */
	public String getAdvImage2() {
		return advImage2;
	}
	/**
	 * @param advImage2 the advImage2 to set
	 */
	public void setAdvImage2(String advImage2) {
		this.advImage2 = advImage2;
	}
	/**
	 * @return the advImage3
	 */
	public String getAdvImage3() {
		return advImage3;
	}
	/**
	 * @param advImage3 the advImage3 to set
	 */
	public void setAdvImage3(String advImage3) {
		this.advImage3 = advImage3;
	}
	/**
	 * @return the advVideo
	 */
	public String getAdvVideo() {
		return advVideo;
	}
	/**
	 * @param advVideo the advVideo to set
	 */
	public void setAdvVideo(String advVideo) {
		this.advVideo = advVideo;
	}
	/**
	 * @return the advCategory
	 */
	public String getAdvCategory() {
		return advCategory;
	}
	/**
	 * @param advCategory the advCategory to set
	 */
	public void setAdvCategory(String advCategory) {
		this.advCategory = advCategory;
	}
	/**
	 * @return the advSubCategory
	 */
	public String getAdvSubCategory() {
		return advSubCategory;
	}
	/**
	 * @param advSubCategory the advSubCategory to set
	 */
	public void setAdvSubCategory(String advSubCategory) {
		this.advSubCategory = advSubCategory;
	}
	/**
	 * @return the advPriority
	 */
	public String getAdvPriority() {
		return advPriority;
	}
	/**
	 * @param advPriority the advPriority to set
	 */
	public void setAdvPriority(String advPriority) {
		this.advPriority = advPriority;
	}
	
	
	
}
