package com.database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.model.CreateAdvInfo;
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
	//RegisterPage
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

//LoginPage
  public static boolean doesUserExists(String userName){
  	boolean status=false;
  	    
  	try
  	{
      		Connection con =DriverManager.getConnection(DBURL,DBUSER,DBPASS);
  			Statement st=con.createStatement();
  	    	ResultSet rs=st.executeQuery("select *from advertiserDetails where advertiserId='"+userName+"' " );
  	    	if(rs.next())
  	    	{
  	    		status=true;
  	    	
  	    	}
  
      }
      catch(Exception ex){
          System.out.println("Error userexist : "+ex); 
      }
      return status;
 
}
  public static RegUserInfo loginUser(String userName, String password){
      RegUserInfo info = null;
      try
      (
      		
      	
      		
          Connection con = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
          PreparedStatement st = con.prepareStatement("select * from advertiserDetails where advertiserId=? and password=?");
      )
      {
      	
          st.setString(2, userName);
          st.setString(6, password);
          ResultSet rs = st.executeQuery();       //Read
          if(rs.next()){
          	System.out.println("insider");
              info = new RegUserInfo();
              info.setAdvName(rs.getString("Name"));
              info.setAdvId(rs.getString("Id"));
              info.setAdvPassword(rs.getString("Password"));
              info.setAdvAddress(rs.getString("Address"));
              info.setAdvContact(rs.getString("Phone"));
              info.setAdvQuestion(rs.getString("Question"));
              info.setAdvAns(rs.getString("Answer"));
          }
      }
      catch(Exception ex){
          System.out.println("Error loginUser : "+ex);
      }
      return info;
  }

  //CreativeAdvertiserPage
public static boolean uploadImage(CreateAdvInfo info) {
	// TODO Auto-generated method stub
   boolean temp=false;
	InputStream inputStream=null;
	try
	
    	(	Connection con =DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		PreparedStatement ps=con.prepareStatement("insert into advertiser_table1 values (?,1,?,?,?,?,?,?,?,?,?,?,?)");
	    	
	){
	
	ps.setString(1, info.getAdvUser());
    ps.setString(2, "1");
    if (inputStream != null) {
        // fetches input stream of the upload file for the blob column
        ps.setBlob(3, inputStream);
    }
   // ps.setString(3, info.getAdvTitle());
    ps.setString(5, info.getAdvDescription());
    if (inputStream != null) {
        // fetches input stream of the upload file for the blob column
        ps.setBlob(6, inputStream);
        ps.setBlob(7, inputStream);
        ps.setBlob(8, inputStream);
        ps.setBlob(9, inputStream);
    }
   /* ps.setString(6, info.getAdvImage1());
    ps.setString(7, info.getAdvImage2());
    ps.setString(8, info.getAdvImage3());
    ps.setString(9,info.getAdvVideo());*/
    //ps.setString(10,info.getAdvVideo());
    ps.setString(10, info.getAdvCategory());	
    ps.setString(11, info.getAdvSubCategory());
    ps.setString(12, info.getAdvPriority());
    ps.setString(13,"no");
    
    // size must be converted to int otherwise it results in error
   // ps.setBinaryStream(3, file.getInputStream(), (int) file.getSize());
    //ps.setBinaryStream(4, file.getInputStream(), (int) file.getSize());
    ps.executeUpdate();
}
    catch(Exception ex) {
        System.out.println( "Error --> " + ex.getMessage());
    }
	return temp;
}
}        


