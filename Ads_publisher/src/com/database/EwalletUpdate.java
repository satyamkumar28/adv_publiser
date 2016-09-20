package com.database;


import java.sql.*;

public class EwalletUpdate {

	    public static int setupdatedewallet(String user,int ewallet)
	    {
	        ResultSet rs=null;
	        int i=0;
	        try
	        {
	        
	             Connection con=DBmanager.getconnection();
	             PreparedStatement ps=con.prepareStatement("Update adsusers set ewallet="+ewallet+" where userid='"+user+"'");
	             i=ps.executeUpdate();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        
	        return i;
	    }
	
}
