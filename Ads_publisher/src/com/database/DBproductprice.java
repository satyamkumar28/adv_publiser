package com.database;



import java.sql.*;


public class DBproductprice {
		
		public static int getproductprice(String t)
		    {
		        int price=0;
				ResultSet rs=null;
				
		        try
		        {
		        	
		             Connection con=DBmanager.getconnection();
		             PreparedStatement ps=con.prepareStatement("select * from ADSPRODUCTS where PRODUCTNAME=?");
		             
		 			ps.setString(1,t);
		 			rs=ps.executeQuery();
		 			
		 			if(rs.next())
		 			{
		 				price=rs.getInt(2);		 			
		        	}
		            
		        }
		        catch(Exception e)
		        {
		            e.printStackTrace();
		        }
		        
		        return price;
		    }
}
