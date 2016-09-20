/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

public class AdInfo {
    private String advertiserid;
    private int adid;
    private String title;
    private String description;
    private String themeimage;
    private String image1;
    private String image2;
    private String image3;
    public AdInfo(String advertiserid, int adid, String title, String themeimage, String description, String image1,
			String image2, String image3, String video, String category, String subcategory, int priority) {
		super();
		this.advertiserid = advertiserid;
		this.adid = adid;
		this.title = title;
		this.description = description;
		this.themeimage = themeimage;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.video = video;
		this.category = category;
		this.subcategory = subcategory;
		this.priority = priority;
	}

	private String video;
    private String category;
    private String subcategory;
    private int priority;

    private byte[] img;
    public AdInfo(){}

    public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

    public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getAdvertiserid() {
		return advertiserid;
	}

	public void setAdvertiserid(String advertiserid) {
		this.advertiserid = advertiserid;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	private String approve;
    public String getThemeimage() {
		return themeimage;
	}

	public void setThemeimage(String themeimage) {
		this.themeimage = themeimage;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAdid() {
		return adid;
	}

	public void setAdid(int adid) {
		this.adid = adid;
	}


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
}
