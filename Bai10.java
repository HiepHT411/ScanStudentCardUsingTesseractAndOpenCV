package com.hoanghiep.onthi;

import java.util.Scanner;

public class Bai10 {

	static int getInput(){
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		return number;
	}
	
	static void layToHop(int n, int k, int arr[], int i) {
		for (int j = arr[i-1] + 1; j <= n-k+i; j++)  {
	        arr[i] = j;
	        if (i == k)
	            inToHop(arr, k);
	        else
	            layToHop(n, k,  arr, i+1);
	    }
	}
	
	static void inToHop(int arr[], int k) {
		for (int i = 1; i <= k; i++)
	        System.out.printf("%3d", arr[i]);
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("Liet ke tap con k phan tu cua day n phan tu");
		
		System.out.println("Nhap n:");
		int n = getInput();
		
		System.out.println("Nhap k: ");
		int k = getInput();
		
		int a[] = new int[n];
//		for(int i=0; i<n; i++) {	//khoi tao
//			a[i]=i;
//		}

		layToHop(n, k, a, 1);
		
	}

}
