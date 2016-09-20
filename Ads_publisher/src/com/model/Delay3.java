package com.model;
import java.lang.*;

public class Delay3 implements Runnable {
	
	Thread t;
	public void run()
	{
		try
		{
			t.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void getdelay(int time)
	{
	  
	}
	
	
}
