package com.hoanghiep.onthi;

import java.util.Scanner;

public class Bai3 {

	static int getInput(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap so:");
		int number = sc.nextInt();
		
		return number;
	}
	
	public static void main(String[] args) {
		System.out.println("Tinh tong cac chu so cua so nguyen bat ky");
		
		int n = getInput();
		int tong = 0;
		int remainder = n;
		while(remainder>0) {
			tong += remainder%10;
			remainder /= 10;
		}
		System.out.printf("tong cac chu so cua so nguyen %d la %d", n, tong);
	}

}
