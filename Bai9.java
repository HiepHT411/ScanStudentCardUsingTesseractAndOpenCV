package com.hoanghiep.onthi;

import java.util.Scanner;

public class Bai9 {
	static int getInput(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap so:");
		int number = sc.nextInt();
		
		return number;
	}
	
	public static void main(String[] args) {
		System.out.println("Liet ke xau nhi phan co do dai n (0<n<=7)");
		
		int n = getInput();
		
		String nbr[] = new String[128];
		
		nbr[0] = "0";
		nbr[1] = "1";
		int t = 2;  //su dung mang tu vi tri thu 2, 2 vi tri dau tien khoi tao
		int k = 0;
		while(nbr[k].length() < n) {
			nbr[t++] = nbr[k] + "0";
	        nbr[t++] = nbr[k] + "1";
	        k++;
		}
		
		for (int i = k; i < t; i++)
	        System.out.println(nbr[i]);
	}
}
