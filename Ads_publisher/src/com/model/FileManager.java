package com.model;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;

import javax.imageio.ImageIO;

public class FileManager {
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
	
	
	 public static String saveUploadedFile(AdInfo user) throws FileNotFoundException{
		 BufferedImage bImageFromConvert = null ;
		 InputStream in = new ByteArrayInputStream(user.getImg());
			try {
				bImageFromConvert = ImageIO.read(in);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			RenderedImage renderedImage=(RenderedImage)bImageFromConvert;
			
			String path="F:/advertiserimages/"+user.getSubcategory()+randomString(3)+".jpg";
			path+="";
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			
			try {
				ImageIO.write(renderedImage, "jpg", fileOutputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Image Saved Successfully");
			return path;
	    }   
private static String randomString(int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
}

///////////////////////////

