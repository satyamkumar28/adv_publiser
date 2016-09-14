package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;


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

	try{
		Connection con=DriverManager.getConnection(DBURL, DBUSER, DBPASS);
	}catch(Exception ex1){
		System.out.println();
	}
}
}

