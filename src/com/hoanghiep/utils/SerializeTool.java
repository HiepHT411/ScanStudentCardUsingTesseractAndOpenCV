package com.hoanghiep.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializeTool {
	
	public static boolean saveFile(String text, String path) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(text);
			System.out.println("Save imageText to: "+ path);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null)
					fos.close();
				if(oos != null)
					oos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}
	
	
	public static String readFile(String path) {
		String studentInfo = "";
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(path);
			ois = new ObjectInputStream(fis);
			
			Object data = ois.readObject();
			studentInfo = (String) data;
			
			System.out.println("Read from: "+path);

			return studentInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(ois != null) {
						ois.close();
					}
					if(fis != null) {
						fis.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
}
