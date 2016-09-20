package com.database;


import java.util.*;
import java.sql.*;

public class DBproduct {
	
	public static HashMap<Integer,String> getproducts()
	    {
			String productname="";
			int price=0;
	        ResultSet rs=null;
	        HashMap<Integer,String> list=new HashMap<Integer,String>();
	        try
	        {
	             Connection con=DBmanager.getconnection();
	             PreparedStatement ps=con.prepareStatement("select * from adsproducts");
	             rs=ps.executeQuery();
	             
	             while(rs.next())
	             {
	            	 productname=rs.getString(1);
	            	 price=rs.getInt(2);
	            	 list.put(price,productname);
	             }
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        
	        return list;
	    }
}
