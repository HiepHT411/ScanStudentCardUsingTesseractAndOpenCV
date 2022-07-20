package com.hoanghiep.onthi;

import java.util.Scanner;

public class Bai7 {
	static int getInput(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap so:");
		int number = sc.nextInt();
		
		return number;
	}
	
	static int getFibonacci(int n) {
		int f0 = 0, f1 = 1, fn = 0;
		int count = 0;
		while(count < n-1) {
			f0 = f1;
			f1 = fn; 
			fn = f0+f1;
			count++;
		}
		return fn;
	}
	
	public static void main(String[] args) {
		System.out.println("Tim so fibonacci thu n");
		
		int n = 0;
		
		while (n < 2) {
			n = getInput();
		}
		
		System.out.printf("so fibonacci thu %d la %d", n, getFibonacci(n));
		
		
	}
}
