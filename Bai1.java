package com.hoanghiep.onthi;

import java.util.Scanner;

public class Bai1 {
	
	static int USCLN(int a, int b) {
		while(a*b != 0) {
			if(a >= b) {
				a %= b;
			} else {
				b %= a;
			}
		}
		return a+b;
	}
	
	static int BSCNN(int a, int b) {
		return (a*b)/USCLN(a, b);
	}
	
	static int getInput(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap so:");
		int number = sc.nextInt();
		
		return number;
	}
	
	public static void main(String[] args) {
		System.out.println("Bai1. Tim USCLN va BSCNN");
				
		int a = getInput();
		
		int b = getInput();
		
		System.out.println("USCLN: "+ USCLN(a, b));
		System.out.println("BSCNN: "+ BSCNN(a, b));
	}
}
