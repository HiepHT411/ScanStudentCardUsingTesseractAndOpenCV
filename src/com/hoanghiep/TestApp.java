package com.hoanghiep;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import com.hoanghiep.utils.DoOCRTool;
import com.hoanghiep.utils.ImageResizer;

public class TestApp {
	public static void main(String[] args) {

		String inputImagePath = "src/com/hoanghiep/thesinhvien.jpg";
        String workingImagePath = "src/com/hoanghiep/thesinhvienResized.jpg";
        
		try {
	        
			//Resize ảnh về độ phân giải mặc định (vì độ phân giải ảnh khác nhau)
	        int scaledWidth = 760;
	        int scaledHeight = 475;      
	        ImageResizer.resize(inputImagePath, workingImagePath, scaledWidth, scaledHeight);
			
	        
	       	// Lấy ảnh thể crop bằng BufferedImage
			BufferedImage originalImg = ImageIO.read(new File(workingImagePath));	//ảnh gốc
			BufferedImage subImg;													//ảnh thẻ
			File subImgFile = new File("src/com/hoanghiep/anhthe.jpg");
			System.out.println("Kích thước ảnh gốc: " + originalImg.getWidth() + "x" + originalImg.getHeight()); //760x450

			// open cv
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			CascadeClassifier faceDetector = new CascadeClassifier();
			faceDetector.load("D:\\opencv\\build\\etc\\haarcascades\\haarcascade_frontalface_alt.xml");	
	        // Reading the input image
	        Mat image = Imgcodecs.imread(workingImagePath); //Mat [ 475*760*CV_8UC3, isCont=true, isSubmat=false, nativeObj=0x231f84804d0, dataAddr=0x231f9000080 ]
			// Detecting face
			MatOfRect faceDetections = new MatOfRect();
			faceDetector.detectMultiScale(image, faceDetections);

			// Tạo khung thể hiện đã xác định được khuôn mặt trên ảnh
			for (Rect rect : faceDetections.toArray()) {
				// System.out.println("rect: "+rect);

				Imgproc.rectangle(image, new Point(rect.x, rect.y),
						new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));

				rect.x -= 45; 
				rect.y -= 50;
				rect.width = 180;
				rect.height = 250;

				//Cắt ảnh thẻ
				subImg = originalImg.getSubimage(rect.x, rect.y, rect.width, rect.height); 
				System.out.println("Kích thước ảnh thẻ sau khi crop: " + subImg.getWidth() + "x" + subImg.getHeight()); //180x250
				ImageIO.write(subImg, "jpg", subImgFile);
			}

			// Lưu lại ảnh nhận diện được khuôn mặt
			Imgcodecs.imwrite("src/com/hoanghiep/faceDetected.jpg", image);

			System.out.println("Face Detected");
			System.out.println("Cropped lấy ảnh thẻ sinh viên thành công.");
			System.out.println("=============================================");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		// Đọc text trên ảnh bằng thư viện OCR
		DoOCRTool.doOCRwithPath(workingImagePath);
	}

}
