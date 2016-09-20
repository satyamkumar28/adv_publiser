package com.database;


import java.sql.*;
public class DBuser {

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
}
