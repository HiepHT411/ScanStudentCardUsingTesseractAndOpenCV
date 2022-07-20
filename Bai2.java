package com.hoanghiep.onthi;

import java.util.Scanner;

public class Bai2 {
	
	static int getInput(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap so:");
		int number = sc.nextInt();
		
		return number;
	}
	
	static void convertNumber(int n, int b) {
		if(n<0 || b<2 || b > 16) {
			System.out.println("Gia tri chuyen doi hoac he co so khong hop le");
		} else {
			int remainder = n;
			int tmp;
			char arr[] = new char[20];
			int count = 0;
			
			while (remainder > 0) {
				if (b > 10) {
		            tmp = remainder % b;
		            if (tmp >= 10) {
		                arr[count] = (char) (tmp + 55);	// A dec = 65, F dec = 70 
		                count++;
		            } else {
		                arr[count] = (char) (tmp + 48); // 48dec = 0 char, 57 dec = 9 char
		                count++;
		            }
		        } else {
		            arr[count] = (char) ((remainder % b) + 48);
		            count++;
		        }
		        remainder = remainder / b;
			}
			
			for (int i=count; i >0; i--) {
				System.out.print(arr[i-1]);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Chuyen doi he co so 10 thanh he co so b (1<b<=16)");
		int n = getInput();
		int b = getInput();
		
		System.out.printf("Chuyen %d tu he co so 10 sang he co so %d: \n", n, b);
		convertNumber(n, b);
	}
}
