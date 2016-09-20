/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import com.model.AdInfo;
import com.model.AdvertiserInfo;
import com.model.CustInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



/**
 *
 * @author PC
 */
public class DBmanager {
    
    public static String DBDRIVER = "oracle.jdbc.OracleDriver";
	public static String DBURL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static String DBUSER = "system";
	public static String DBPASSWORD = "system";

	static {
		try {
			Class.forName(DBDRIVER);
		} catch (Exception ex) {
			System.out.println("Error loading the Driver : " + ex);
		}
    
}
	
	///////satyam
	
	  public static boolean  registerAdvertiser(AdvertiserInfo info){
			
		  boolean temp=false;
	    try
	    (
	    		
	    	
	    		
	        Connection con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
	        PreparedStatement st = con.prepareStatement("insert into advertiserdetails values(?,?,?,?,?,?,?)");
	    )
	    {
	    	
	       st.setString(1,info.getName());
	       st.setString(2, info.getAdvertiserId());
	       st.setString(3, info.getPassword());
	       st.setString(4, info.getPhoneNumber());
	       st.setString(5,info.getAddress());
	       st.setString(6, info.getQuestiom());
	       st.setString(7, info.getAnswer());
	            
	        st.executeUpdate();
	        temp=true;
	    }
	    catch(Exception ex1){
	        System.out.println("Error search user : "+ex1);
	    }
	    return temp;
	  }

public static boolean loginUser(String userName, String password){
	boolean temp = false;
    try
    (
    		
    	
    		
        Connection con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        PreparedStatement st = con.prepareStatement("select * from advertiserdetails where adertiserid=? and password=?");
    )
    {
    	
        st.setString(1, userName);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();       //Read
        if(rs.next()){
        	System.out.println("insider");
        	temp=true;
        }
    }
    catch(Exception ex){
        System.out.println("Error loginUser : "+ex);
    }
    return temp;
}
    ///////satyam
	///////////////////////////////
	///////ashish
    public static Connection getconnection()
    {
        Connection con=null;
        try
        {
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            String user="system";
            String password="system";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection(url,user,password);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return con;
    }
    //////ashish
	
        public static boolean insertCategory(AdInfo info) {
		// TODO Auto-generated method stub
    	boolean temp=false;
	    
    	try
    	{
        		  Connection con =DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
    		      PreparedStatement st=con.prepareStatement("insert into CATEGORY values (?)");
    	    	
    	st.setString(1,info.getCategory());
    	st.executeUpdate();
    	temp=true;
    	
    
        }
        catch(Exception ex){
            System.out.println("Error registeruser : "+ex);
        }
        return temp;

	}
        
        public static ArrayList<AdInfo> getCategories(){
        	ArrayList<AdInfo> alist=new ArrayList<AdInfo>();
        	
        	try
        	{
        		Connection con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        		PreparedStatement st = con.prepareStatement("select * from CATEGORY");
        		
        	ResultSet rs =	st.executeQuery();
        	while(rs.next()){
        		
        		AdInfo info = new AdInfo();
        		info.setCategory(rs.getString("categories"));
        		alist.add(info);
        	}
        		
        	}
        	  catch(Exception ex){
                  System.out.println("Error getting Category : "+ex);
              }
              return alist;
        }
        public static ArrayList<AdInfo> getSubCategories(){
        	ArrayList<AdInfo> alist=new ArrayList<AdInfo>();
        	
        	try
        	{
        		Connection con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        		PreparedStatement st = con.prepareStatement("select sub_categories from sub_categories");
        		
        	ResultSet rs =	st.executeQuery();
        	while(rs.next()){
        		
        		AdInfo info = new AdInfo();
        		info.setSubcategory(rs.getString("sub_categories"));
        		alist.add(info);
        	}
        		
        	}
        	  catch(Exception ex){
                  System.out.println("Error getting Category : "+ex);
              }
              return alist;
        }
        
		public static boolean insertSubCategory(AdInfo info) {
			// TODO Auto-generated method stub
			boolean temp=false;
		    
	    	try
	    	{
	        		  Connection con =DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
	    		      PreparedStatement st=con.prepareStatement("insert into SUB_CATEGORIES values (?,?)");
	    	    	
	    	st.setString(1,info.getSubcategory());
	    	st.setString(2,info.getCategory());
	    	st.executeUpdate();
	    	temp=true;
	    	
	    
	        }
	        catch(Exception ex){
	            System.out.println("Error registeruser : "+ex);
	        }
	        return temp;

		
		}
        public static ArrayList<AdInfo> getSubCategories(String cat){
        	ArrayList<AdInfo> alist=new ArrayList<AdInfo>();
        	
        	try
        	{
        		Connection con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        		PreparedStatement st = con.prepareStatement("select sub_categories from SUB_CATEGORIES where categories=(?)");
        		
        		st.setString(1, cat);
        	ResultSet rs =	st.executeQuery();
        	while(rs.next()){
        		
        		AdInfo info = new AdInfo();
        		info.setSubcategory(rs.getString("sub_categories"));
        		alist.add(info);
        	}
        		
        	}
        	  catch(Exception ex){
                  System.out.println("Error getting Category : "+ex);
              }
              return alist;
        }
		public static ArrayList<AdInfo> getUnApprovedAds() {
			// TODO Auto-generated method stub
ArrayList<AdInfo> alist=new ArrayList<AdInfo>();

        	
        	try
        	{
        		Connection con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        		PreparedStatement st = con.prepareStatement("select adid,title,themeimage,description,image1,image2,image3,video from advertiser_table where approve=(?) order by PRIORTY desc");
        		
        		st.setString(1, "false");
        		ResultSet rs =	st.executeQuery();
        	while(rs.next()){
        		
        		AdInfo info = new AdInfo();
        		info.setAdid(rs.getInt("adid"));
        		info.setTitle(rs.getString("title"));
        		info.setDescription(rs.getString("description"));
        		info.setThemeimage(rs.getString("themeimage"));
        		info.setImage1(rs.getString("image1"));
        		info.setImage2(rs.getString("image2"));
        		info.setImage3(rs.getString("image3"));
        		info.setVideo(rs.getString("video"));
        		alist.add(info);
        		System.out.println(rs.getString("title"));
        	}
        		
        	}
        	  catch(Exception ex){
                  System.out.println("Error getting Category : "+ex);
              }
              return alist;
			
		}
		public static boolean approve(int adid) {
			// TODO Auto-generated method stub
	boolean temp=false;
		    
	    	try
	    	{
	        		  Connection con =DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
	    		      PreparedStatement st=con.prepareStatement("update advertiser_table set approve=(?)  where adid=(?)");
	    	    	
	    	st.setString(1,"true");
	    	st.setInt(2,adid);
	    	st.executeUpdate();
	    	temp=true;
	    	
	    
	        }
	        catch(Exception ex){
	            System.out.println("Error registeruser : "+ex);
	        }
	        return temp;

		}
		public static boolean deleteAd(int adid) {
			// TODO Auto-generated method stub
boolean temp=false;
		    
	    	try
	    	{
	        		  Connection con =DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
	    		      PreparedStatement st=con.prepareStatement("delete from advertiser_table  where adid=(?)");
	    	    	
	    	
	    	st.setInt(1,adid);
	    	st.executeUpdate();
	    	temp=true;
	    	
	    
	        }
	        catch(Exception ex){
	            System.out.println("Error registeruser : "+ex);
	        }
	        return temp;
		}
		public static boolean createProduct(String pname, String price) {
			// TODO Auto-generated method stub
	boolean temp=false;
		    
	    	try
	    	{
	        		  Connection con =DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
	    		      PreparedStatement st=con.prepareStatement("insert into adsproducts values (?,?)");
	    	    	
	    	st.setString(1,pname);
	    	st.setString(2,price);
	    	st.executeUpdate();
	    	temp=true;
	    	
	    
	        }
	        catch(Exception ex){
	            System.out.println("Error registeruser : "+ex);
	        }
	        return temp;

		}
		public static boolean categoryexist(String param) {
			// TODO Auto-generated method stub
			boolean temp= false;
	    	try
        	{
        		Connection con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        		PreparedStatement st = con.prepareStatement("select * from CATEGORY where categories=(?)");
        		
        		st.setString(1, param);
        	ResultSet rs =	st.executeQuery();
        	if(rs.next()){
        		
        		temp= true;
        	}
        		
        	}
        	  catch(Exception ex){
                  System.out.println("Error getting Category : "+ex);
              }
              return temp;
		}
		public static boolean subcategoryexist(String param) {
			// TODO Auto-generated method stub
			boolean temp= false;
	    	try
        	{
        		Connection con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        		PreparedStatement st = con.prepareStatement("select * from sub_categories where sub_categories=(?)");
        		
        		st.setString(1, param);
        	ResultSet rs =	st.executeQuery();
        	if(rs.next()){
        		
        		temp= true;
        	}
        		
        	}
        	  catch(Exception ex){
                  System.out.println("Error getting Category : "+ex);
              }
              return temp;
		}
		public static ArrayList<AdInfo> showAds(String cat) {
			// TODO Auto-generated method stub
			ArrayList<AdInfo> alist=new ArrayList<AdInfo>();
        	try
        	{
        		Connection con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        		PreparedStatement st = con.prepareStatement("select adid,title,themeimage from advertiser_table where category=(?) order by PRIORTY desc");
        		
        		st.setString(1, cat);
        	ResultSet rs =	st.executeQuery();
            System.out.println("Error getting 1");
        	while(rs.next()){
                System.out.println("Error getting 1");
        		AdInfo info = new AdInfo();
        		info.setAdid(rs.getInt("adid"));
        		info.setTitle(rs.getString("title"));
        		info.setThemeimage(rs.getString("themeimage"));
        		alist.add(info);
        	}
        		
        	}
        	  catch(Exception ex){
                  System.out.println("Error getting Category : "+ex);
              }
              return alist;
		}
		public static ArrayList<AdInfo> showAds1(String subcat) {
			// TODO Auto-generated method stub
			ArrayList<AdInfo> alist=new ArrayList<AdInfo>();
        	try
        	(
        		Connection con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        		PreparedStatement st = con.prepareStatement("select * from ADVERTISER_TABLE ");)
        	{
        		
        	//st.setString(1, subcat);
        	ResultSet rs =	st.executeQuery();
        	
        	System.out.println("Error getting 1 "+subcat+ " " +rs.next());
        	
        	while(rs.next())
        	{
        		System.out.println("Error getting 2");
        		AdInfo info = new AdInfo();
        		info.setAdid(rs.getInt("adid"));
        		info.setTitle(rs.getString("title"));
        		info.setThemeimage(rs.getString("themeimage"));
        		alist.add(info);
                System.out.println("Error getting 1");
        	}
        		
        	}
        	  catch(Exception ex){
                  System.out.println("Error getting Category : "+ex);
              }
              return alist;
		}
		public static AdvertiserInfo getAdvertiserDetails(String id) {
			// TODO Auto-generated method stub

    		AdvertiserInfo info = new AdvertiserInfo();
        	try
        	{
        		Connection con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        		PreparedStatement st = con.prepareStatement("select * from advertiserdetails where adertiserid=(?) ");
        		
        		st.setString(1, id);
        	ResultSet rs =	st.executeQuery();
        	while(rs.next()){
        		
        		
        		info.setAdvertiserId(rs.getString("adertiserid"));
        		info.setName(rs.getString("name"));
        		info.setPhoneNumber(rs.getString("phonenumber"));
        		info.setAddress(rs.getString("address"));
        		
        	}
        		
        	}
        	  catch(Exception ex){
                  System.out.println("Error getting Category : "+ex);
              }
              return info;
		}
		public static CustInfo getUserDetails(String id) {
			// TODO Auto-generated method stub

    		CustInfo info1 = new CustInfo();
        	try
        	{
        		Connection con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        		PreparedStatement st = con.prepareStatement("select * from adsusers where userid=(?) ");
        		
        		st.setString(1, id);
        	ResultSet rs =	st.executeQuery();
        	while(rs.next()){
        		
        		
        		info1.setName(rs.getString("name"));
        		info1.setAddress(rs.getString("address"));
        		info1.setEwallet(rs.getInt("ewallet"));
        		info1.setAddress(rs.getString("address"));
        		info1.setPhone(rs.getLong("phno"));
        		
        	}
        		
        	}
        	  catch(Exception ex){
                  System.out.println("Error getting Category : "+ex);
              }
              return info1;
		}

		public static int getId() {
			// TODO Auto-generated method stub
			int id=1;
			try
        	{
        		Connection con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        		PreparedStatement st = con.prepareStatement("select max(adid) from advertiser_table ");
        		
        		
        	ResultSet rs =	st.executeQuery();
        	while(rs.next()){
        		id= rs.getInt("max(adid)");
      
        		
        	}
        		
        	}
        	  catch(Exception ex){
                  System.out.println("Error getting id : "+ex);
              }
              return id;
		}

		public static boolean addAds(AdInfo info) {
			// TODO Auto-generated method stub
			  boolean temp=false;
			    try
			    (
			    		
			    	
			    		
			        Connection con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
			        PreparedStatement st = con.prepareStatement("insert into advertiser_table values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			    )
			    {
			    	
			       st.setString(1,info.getAdvertiserid());
			       st.setInt(2, info.getAdid());
			       st.setString(3, info.getTitle());
			       st.setString(4, info.getThemeimage());
			       st.setString(5,info.getDescription());
			       st.setString(6, info.getImage1());
			       st.setString(7, info.getImage2());
			       st.setString(8, info.getImage3());
			       st.setString(9, info.getVideo());
			       st.setString(10, info.getCategory());
			       st.setString(11, info.getSubcategory());
			       st.setInt(12, info.getPriority());
			       st.setString(13, "false");
			            
			        st.executeUpdate();
			        temp=true;
			    }
			    catch(Exception ex1){
			        System.out.println("Error search user : "+ex1);
			    }
			    return temp;
		}

		}
		
		///////////////////////////////end
