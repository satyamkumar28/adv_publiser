package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


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
	
  public static RegUserInfo getInfo(String name){
	RegUserInfo info = null;
    try
    (
    		
    	
    		
        Connection con = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        PreparedStatement st = con.prepareStatement("select * from ADVERTISERDETAILS where name=?");
    )
    {
    	
       st.setString(1,name);
        ResultSet rs = st.executeQuery();       //Read
        if(rs.next()){
        	System.out.println("insider");
            info = new RegUserInfo();
            info.setAdvName(rs.getString("Name"));
            info.setAdvId(rs.getString("Id"));
            info.setAdvContact(rs.getString("Phone"));
            info.setAdvQuestion(rs.getString("Question"));
            info.setAdvAns(rs.getString("Answer"));
            info.setAdvPassword(rs.getString("Password"));
System.out.println("whats going on");
            
        }
    }
    catch(Exception ex1){
        System.out.println("Error search user : "+ex1);
    }
    return info;
  }
}
/*	try{
		Connection con=DriverManager.getConnection(DBURL, DBUSER, DBPASS);
	}catch(Exception ex1){
		System.out.println();
	}
}*/


