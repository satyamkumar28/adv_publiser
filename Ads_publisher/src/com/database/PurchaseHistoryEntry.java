package com.database;


import java.sql.*;

public class PurchaseHistoryEntry {

	    public static int setproducthistory(String user,String productname)
	    {
	    	int i=0;
	       
	        try
	        {
	        
	             Connection con=DBmanager.getconnection();
	             PreparedStatement ps=con.prepareStatement("Insert into ADSPURCHASEHISTORY values(?,?)");
	             ps.setString(1, user);
	             ps.setString(2, productname);
	             i=ps.executeUpdate();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        
	        
	        return i;
	    }
	
}
