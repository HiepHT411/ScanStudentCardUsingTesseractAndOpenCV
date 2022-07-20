package com.hoanghiep.onthi;

import java.util.Scanner;

public class Bai5 {
	static int getInput(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap so:");
		int number = sc.nextInt();
		
		return number;
	}
	
	static boolean kiemTraSoNguyenTo(int a){
		
		if (a < 1) {
	        return false;
	    }
	    // check so nguyen to khi n >= 2
	    int i;
	    int squareRoot = (int) Math.sqrt(a);
	    for (i = 2; i <= squareRoot; i++) {
	        if (a % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		System.out.println("Liet ke tat ca cac so nguyen to nho hon n");
		
		int n = getInput();
		
		System.out.println("so nguyen to nho hon n: ");
		
		for (int i=2; i<n; i++) {
			if(kiemTraSoNguyenTo(i)) {
				System.out.print(i + " ");
			}
		}
		
	}
}
