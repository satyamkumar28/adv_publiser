package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.RegUserInfo;


public class DbManger {
	public static String DRIVER = "oracle.jdbc.OracleDriver" ;
	public static String DBURL="jdbc:oracle:thin:@localhost:1521:xe";
	public static String DBUSER="system";
	public static String DBPASS="system";
	static 
	{
		try{

		Class.forName(DRIVER);
	}catch( Exception ex){
		System.out.println("Register Driver" +ex);
	}
	}
	
  public static boolean  registerAdvertiser(RegUserInfo info){
	
	  boolean temp=false;
    try
    (
    		
    	
    		
        Connection con = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        PreparedStatement st = con.prepareStatement("insert into advertiserdetails values(?,?,?,?,?,?,?)");
    )
    {
    	
       st.setString(1,info.getAdvName());
       st.setString(2, info.getAdvId());
       st.setString(3, info.getAdvContact());
       st.setString(4, info.getAdvAddress());
       st.setString(5,info.getAdvQuestion());
       st.setString(6, info.getAdvAns());
       st.setString(7, info.getAdvPassword());
            
        st.executeUpdate();
        temp=true;
    }
    catch(Exception ex1){
        System.out.println("Error search user : "+ex1);
    }
    return temp;
  }
}


