package com.model;

import java.sql.*;
import java.util.*;

import com.database.DBmanager;

public class CustInfo {

	private String id,password,question,answer,productname,category,subcategory;
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

	private String name,address;
	private long phone;
	private int productprice,previous,next,imgid1,imgid2,imgid3,imgid4,imgid5,imgid6,imgid7,imgid8,imgid9,imgid10,popupimgid,start;
	private int listtotal;

	public int getListtotal() {
		return listtotal;
	}

	public void setListtotal(int listtotal) {
		this.listtotal = listtotal;
	}

	public int getPopupimgid() {
		return popupimgid;
	}

	public void setPopupimgid(int popupimgid) {
		this.popupimgid = popupimgid;
	}

	public int getImgid4() {
		return imgid4;
	}

	public void setImgid4(int imgid4) {
		this.imgid4 = imgid4;
	}

	public int getImgid5() {
		return imgid5;
	}

	public void setImgid5(int imgid5) {
		this.imgid5 = imgid5;
	}

	public int getImgid6() {
		return imgid6;
	}

	public void setImgid6(int imgid6) {
		this.imgid6 = imgid6;
	}

	public int getImgid7() {
		return imgid7;
	}

	public void setImgid7(int imgid7) {
		this.imgid7 = imgid7;
	}

	public int getImgid8() {
		return imgid8;
	}

	public void setImgid8(int imgid8) {
		this.imgid8 = imgid8;
	}

	public int getImgid9() {
		return imgid9;
	}

	public void setImgid9(int imgid9) {
		this.imgid9 = imgid9;
	}

	public int getImgid10() {
		return imgid10;
	}

	public void setImgid10(int imgid10) {
		this.imgid10 = imgid10;
	}

	public int getImgid3() {
		return imgid3;
	}

	public void setImgid3(int imgid3) {
		this.imgid3 = imgid3;
	}

	public int getImgid1() {
		return imgid1;
	}

	public void setImgid1(int imgid1) {
		this.imgid1 = imgid1;
	}

	public int getImgid2() {
		return imgid2;
	}

	public void setImgid2(int imgid2) {
		this.imgid2 = imgid2;
	}

	public int getPrevious() {
		return previous;
	}

	public void setPrevious(int previous) {
		this.previous = previous;
	}

	public int getNext() {
		return next;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getProductprice() {
		return productprice;
	}

	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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

	public int getEwallet() {
		return ewallet;
	}

	public void setEwallet(int ewallet) {
		this.ewallet = ewallet;
	}

	private int ewallet;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String findProductname(String productn)
	{
		int length=0,i=0;
		String temp="";
		
			length=productn.length();
			for(i=0;i<=length;i++)
			{
				if(productn.charAt(i)==' ')
				{
					break;
				}
				else
				{
					temp+=productn.charAt(i);
				}
			}
			
		
		return temp;
	}
	
	public static HashMap<Integer,Integer> getusersearchads(String userid)
	{
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		int advid=1,key=1,i=0;
		
		
		try
		{
			Connection con=DBmanager.getconnection();
			PreparedStatement ps=con.prepareStatement("select * from ADVERTISER_TABLE where APPROVE='true' order by PRIORTY");
			//PreparedStatement ps=con.prepareStatement("select adid from ADVERTISER_TABLE where CATEGORY='true' and SUBCATEGORY='true' and approve='true'");
			
			ResultSet rs=ps.executeQuery();
		
			while(rs.next())
			{
				advid=rs.getInt("ADID");
				
                            try
                            {        
                            	PreparedStatement pst=con.prepareStatement("select * from adshistory where userid=? and advid=?");
                				pst.setString(1,userid);
                				pst.setInt(2,advid);
                				ResultSet rs1=pst.executeQuery();
                				while(rs1.next())
                				{
                					i=1;
                				}
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                            if(i==0)
                            {
                            	advid=rs.getInt("ADID");
                            	hm.put(key,advid);
                            	key++;
                            }
                  else{i=0;}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hm;
	}

	
	public static HashMap<Integer,Integer> getguestsearchads(String category,String subcategory)
	{
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		int advid=1,key=1,i=0;
		
		try
		{
			Connection con=DBmanager.getconnection();
			PreparedStatement ps=con.prepareStatement("select * from ADVERTISER_TABLE where CATEGORY='"+category+"' and SUBCATEGORY='"+subcategory+"' and APPROVED='true' order by PRIORTY");
			//PreparedStatement ps=con.prepareStatement("select adid from ADVERTISER_TABLE where CATEGORY='true' and SUBCATEGORY='true' and approved='true'");
			
			ResultSet rs=ps.executeQuery();
		
			while(rs.next())
			{
				advid=rs.getInt(1);
						/*
                            try
                            {        
                            	PreparedStatement pst=con.prepareStatement("select * from adshistory where advid=? userid=?");
                				pst.setString(2,userid);
                				pst.setInt(1,advid);
                				ResultSet rs1=pst.executeQuery();
                				while(rs1.next())
                				{
                					i=1;
                				}
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                           */ 
                            if(i==0)
                            {
                            	advid=rs.getInt(1);
                            	hm.put(key,advid);
                            	key++;
                            }
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hm;
	}	
}
