package com.database;

import com.model.*;
import java.sql.*;

public class DBad {

	    public static ResultSet getresultset(String user)
	    {
	        ResultSet rs=null;
	        try
	        {
	        
	             Connection con=DBmanager.getconnection();
	             PreparedStatement ps=con.prepareStatement("select * from adsusers where userid='"+user+"'");
	             rs=ps.executeQuery();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        
	        return rs;
	    }
	    
	    
	    public static ResultSet getadsresultset(int advid)
	    {
	        ResultSet rs=null;
	        try
	        {
	        
	             Connection con=DBmanager.getconnection();
	             PreparedStatement ps=con.prepareStatement("select * from advertiser_table where adid=?");
	             ps.setInt(1, advid);
	             rs=ps.executeQuery();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        
	        return rs;
	    }
	    
	    
	    
	    

}
