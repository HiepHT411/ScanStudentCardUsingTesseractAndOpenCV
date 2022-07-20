package com.hoanghiep.onthi;

import java.util.Scanner;

public class Bai4 {
	static int getInput(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap so:");
		int number = sc.nextInt();
		
		return number;
	}
	
	public static void main(String[] args) {
		System.out.println("Phan tich so nguyen thanh cac so nguyen to");
		int n = getInput();
		
		int arr[] = new int[20];
		
		for(int i=2; i<=n; i++) {
			int count = 0;
			while(n % i == 0) {
				arr[count] = i;
				count ++;
				n /= i;
			}
			if(count > 0) {
				for(int j=1; j<=count; j++) {
					System.out.print(i+ " x ");
				}
			}
		}
	}
}
