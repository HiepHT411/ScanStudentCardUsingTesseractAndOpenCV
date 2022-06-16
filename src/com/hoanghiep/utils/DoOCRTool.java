package com.hoanghiep.utils;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;

public class DoOCRTool {

	public static void doOCRwithPath(String path) {
		Tesseract tess = new Tesseract();
		String imageText = null;
		try {
			System.out.println("Scan image text......");
			tess.setDatapath("D:\\Java Jars\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
			
			tess.setLanguage("vie");
			imageText = tess.doOCR(new File(path));
			
			System.out.println(imageText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SerializeTool.saveFile(imageText, "SerializedFile/data.txt");
	}

}
